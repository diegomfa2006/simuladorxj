package com.dmfa.simuladorxj.services;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.MessageType;
import com.dmfa.simuladorxj.utils.ConsoleColors;
import com.dmfa.simuladorxj.utils.FileUtils;
import com.dmfa.simuladorxj.utils.FindUtils;
import com.dmfa.simuladorxj.utils.HeaderUtils;
import com.dmfa.simuladorxj.utils.PersistenceInfoUtils;

public class FindServices {

	public static void findMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println();
		System.out.println(ConsoleColors.WHITE_BRIGHT + "=============================================" + ConsoleColors.RESET);
		System.out.println();
		System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "::::::::  REQUEST ::::::::" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "METHOD: " + ConsoleColors.RESET +  request.getMethod());
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "URI: " + ConsoleColors.RESET + request.getRequestURI());
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "-- Headers --" + ConsoleColors.RESET);
		printHeadersRq(request);
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "-- Body Content --" + ConsoleColors.RESET);
		System.out.println(FileUtils.convertToString(request.getInputStream(), "UTF-8"));
		
		ApplicationType app = FindUtils.findApplication(PersistenceInfoUtils.getConfig(), request);

		if (app!= null) {
			
			System.out.println();
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "::::::::  SEARCH INFO ::::::::" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BRIGHT + "APP: " + ConsoleColors.RESET + app.getName());
			System.out.print(ConsoleColors.PURPLE_BRIGHT + "Search type: " + ConsoleColors.RESET + app.getSearchCriteria().getSearchType() + "\t");
			System.out.println(ConsoleColors.PURPLE_BRIGHT + "Content type " + ConsoleColors.RESET + app.getSearchCriteria().getSourceContent());
			
			
			HeaderUtils.setHeaders(response, app.getResponse().getHeaders());
			MessageType messageType = FindUtils.findMessage(app, request);
			
			if(messageType != null) {
				HeaderUtils.setHeaders(response, messageType.getResponse().getHeaders());
				String bodyContentRs = FileUtils.readFile(request.getServletContext().getRealPath("/WEB-INF/classes/responses" + File.separator + app.getBasePath() + File.separator + messageType.getResponseFile()));
				
				response.getWriter().append(bodyContentRs);
				
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
		
	}
	
	public static void printHeadersRq(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName + ": " + request.getHeader(headerName));
		}
	}
	
	public static void printHeadersRs(HttpServletResponse response) {
		Iterator<String> headers = response.getHeaderNames().iterator();
		while (headers.hasNext()) {
			String headerName = headers.next();
			System.out.println(headerName + ": " + response.getHeader(headerName));
		}
	}
}
