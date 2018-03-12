package com.cours.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RootServ
 */
@WebServlet("/RootServ")
public class RootServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RootServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page") != null)
		{
			switch(request.getParameter("page").toString().charAt(0))
			{
				case 'p':
						request.getRequestDispatcher("PatientServ")
							.forward(request, response);
					break;
				
				case 'c':
						request.getRequestDispatcher("ConsultationServ")
							.forward(request, response);
					break;
				case 'm':
					request.getRequestDispatcher("MedecinServ")
							.forward(request, response);
					break;
					
				default:
					
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
