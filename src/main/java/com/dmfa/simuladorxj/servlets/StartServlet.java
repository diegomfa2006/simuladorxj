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
 * Servlet implementation class StartServlet
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(":::::: GET");
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
