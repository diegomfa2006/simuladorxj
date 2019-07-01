package com.dmfa.simuladorxj.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.MessageType;
import com.dmfa.simuladorxj.utils.FileUtils;
import com.dmfa.simuladorxj.utils.FindUtils;
import com.dmfa.simuladorxj.utils.HeaderUtils;
import com.dmfa.simuladorxj.utils.PersistenceInfoUtils;

/**
 * Servlet implementation class ProcessServlet
 */
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProcessServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(".:::: SERVLET JuJu :: " + PersistenceInfoUtils.getConfig());
		
		ApplicationType app = FindUtils.findApplication(PersistenceInfoUtils.getConfig(), request);

		if (app!= null) {
			System.out.println("APP::: " + app.getName());
			
			
			HeaderUtils.setHeaders(response, app.getResponse().getHeaders());
			MessageType messageType = FindUtils.findMessage(app, request);
			
			
			if(messageType != null) {
				System.out.println();
				System.out.println("MENSAJE:: " + app.getBasePath() + File.separator + messageType.getResponseFile());
				
				HeaderUtils.setHeaders(response, messageType.getResponse().getHeaders());
				response.getWriter().append(FileUtils.readFile(getServletContext().getRealPath("/WEB-INF/classes/responses" + File.separator + app.getBasePath() + File.separator + messageType.getResponseFile())));
			}else {
				System.out.println("Mensaje no encontrado");
				
			}
			
			
		} else {
			System.out.println("APP::: NO " );
			response.getWriter().append("Served at: ").append(request.getContextPath()).append( "NO ENCONTRADO" );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	
}
