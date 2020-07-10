package com.dmfa.simuladorxj.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmfa.simuladorxj.beans.Config;
import com.dmfa.simuladorxj.utils.PersistenceInfoUtils;
import com.dmfa.simuladorxj.utils.XmlUtils;

/**
 * This servlet is used for initialize the configuration after start the server
 */
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Recarga de configuracion").append(request.getContextPath());
		init();
		System.out.println("...:::::: Recarga de configuracion ::::::...");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
        
        Config config = XmlUtils.parseToObject(new File(getServletContext().getRealPath("/WEB-INF/classes/xml/applicationMessages.xml")));
        PersistenceInfoUtils.setConfig(config);
        System.out.println(".:::: INIT :: " + config.getApplications().size());
	}
	
	
}
