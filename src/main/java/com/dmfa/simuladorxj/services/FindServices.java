package com.dmfa.simuladorxj.services;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.MessageType;
import com.dmfa.simuladorxj.utils.ConsoleColors;
import com.dmfa.simuladorxj.utils.FileUtils;
import com.dmfa.simuladorxj.utils.FindUtils;
import com.dmfa.simuladorxj.utils.HeaderUtils;
import com.dmfa.simuladorxj.utils.PersistenceInfoUtils;

public class FindServices {

	public static void findMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AnsiConsole.systemInstall();
//		System.out.println(Ansi.ansi().eraseScreen().fg(Color.RED).a("Hello").fg(Color.RED).a(" World").reset());
		
		System.out.println();
		System.out.println(Ansi.ansi().reset().a("============================================="));
		System.out.println();
		System.out.println(Ansi.ansi().bold().fgBrightYellow().a("::::::::  REQUEST ::::::::").reset());
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "METHOD: " + ConsoleColors.RESET +  request.getMethod());
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "URI: " + ConsoleColors.RESET + request.getRequestURI());
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "-- Headers --" + ConsoleColors.RESET);
		printHeadersRq(request);
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "-- Body Content --" + ConsoleColors.RESET);
		request.setAttribute(FindUtils.RQ_ATTRIBUTE_CONTENT, FileUtils.convertToString(request.getInputStream(), "UTF-8"));
		System.out.println(request.getAttribute(FindUtils.RQ_ATTRIBUTE_CONTENT));
		
		
		
		ApplicationType app = FindUtils.findApplication(PersistenceInfoUtils.getConfig(), request);
		
		

		if (app!= null) {
			
			System.out.println();
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "::::::::  SEARCH INFO ::::::::" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BRIGHT + "APP: " + ConsoleColors.RESET + app.getName());
			System.out.print(ConsoleColors.PURPLE_BRIGHT + "Search type: " + ConsoleColors.RESET + app.getSearchCriteria().getSearchType() + "\t");
			System.out.print(ConsoleColors.PURPLE_BRIGHT + "Content type " + ConsoleColors.RESET + app.getSearchCriteria().getSourceContent() + "\t");
			System.out.println(ConsoleColors.PURPLE_BRIGHT + "Eval " + ConsoleColors.RESET + app.getSearchCriteria().getEvalValue());
			
			
			HeaderUtils.setHeaders(response, app.getResponse().getHeaders());
			MessageType messageType = FindUtils.findMessage(app, request);
			
			if(messageType != null) {
				setCodeReponse(response, app.getResponse().getCode(), messageType.getResponse().getCode());
				HeaderUtils.setHeaders(response, messageType.getResponse().getHeaders());
				
				String pathFile = request.getServletContext().getRealPath("/WEB-INF/classes/responses") + File.separator + app.getBasePath() + File.separator + messageType.getResponseFile();
				System.out.println("Archivo a buscar: " + pathFile);
				String bodyContentRs = FileUtils.readFile(pathFile);
				response.getWriter().append(bodyContentRs);
				
				delayForResponse(app.getResponse().getDelay(), messageType.getResponse().getDelay());
				
				System.out.println(ConsoleColors.PURPLE_BRIGHT + "MESSAGE FOUND: " + ConsoleColors.RESET + messageType.getName());
				System.out.print(ConsoleColors.PURPLE_BRIGHT + "Search type: " + ConsoleColors.RESET + messageType.getSearchCriteria().getSearchType() + "\t");
				System.out.println(ConsoleColors.PURPLE_BRIGHT + "Content type " + ConsoleColors.RESET + messageType.getSearchCriteria().getSourceContent());
				System.out.println(ConsoleColors.PURPLE_BRIGHT + "File found : " + ConsoleColors.RESET + app.getBasePath() + File.separator + messageType.getResponseFile());
				
				System.out.println();
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "::::::::  RESPONSE ::::::::" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BRIGHT + "-- Headers --" + ConsoleColors.RESET);
				printHeadersRs(response);
				System.out.println(ConsoleColors.GREEN_BRIGHT + "-- Body Content --" + ConsoleColors.RESET);
				System.out.println(bodyContentRs);
			}else {
				System.out.println(ConsoleColors.PURPLE_BRIGHT + "MESSAGE: " + ConsoleColors.RESET + "Mensaje no encontrado");
			}
			
			
		} else {
			System.out.println();
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "::::::::  RESPONSE ::::::::" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.RED_BRIGHT + "APP: Application not found "  + ConsoleColors.RESET);
		}
		
		System.out.println(ConsoleColors.RESET);
		AnsiConsole.systemUninstall();
	}
	
	private static void printHeadersRq(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName + ": " + request.getHeader(headerName));
		}
	}
	
	private static void printHeadersRs(HttpServletResponse response) {
		Iterator<String> headers = response.getHeaderNames().iterator();
		while (headers.hasNext()) {
			String headerName = headers.next();
			System.out.println(headerName + ": " + response.getHeader(headerName));
		}
	}
	
	private static void delayForResponse(Long delayApp, Long delayMessage) {
		try {
			if(delayMessage!=null && delayMessage>0) {
				Thread.sleep(delayMessage.longValue());
			} else if(delayApp!=null && delayApp>0) {
				Thread.sleep(delayApp.longValue());
			}
		} catch (InterruptedException e) {
			System.out.println(Ansi.ansi().fgBrightRed().a(e.getMessage()));
			Thread.currentThread().interrupt();
		}
	}
	
	private static void setCodeReponse(HttpServletResponse response, Integer codeApp, Integer codeMessage) {
		try {
			if(codeMessage!=null && codeMessage.compareTo(200)!=0) {
				response.sendError(codeMessage.intValue());
			}else if (codeApp!=null && codeApp.compareTo(200)!=0){
				response.sendError(codeApp.intValue());
			}
		} catch (Exception e) {
			System.out.println(Ansi.ansi().fgBrightRed().a(e.getMessage()));
		}
	}
}
