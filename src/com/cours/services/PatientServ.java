package com.cours.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.dao.PatientDAO;
import com.cours.entities.Patient;

/**
 * Servlet implementation class PatientServ
 */
@WebServlet("/PatientServ")
public class PatientServ extends HttpServlet {
	
	private PatientDAO padao;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	 padao = new PatientDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idm") != null)
		{
			//response.getWriter().print(Integer.parseInt(request.getParameter("idm")));
			int i = Integer.parseInt(request.getParameter("idm"));
			Patient p = new Patient();
			p = padao.getPatientById(i);
			request.setAttribute("patient", p);
			request.getRequestDispatcher("/view/patient/update.jsp")
					.forward(request, response);
		}
		if(request.getParameter("ids") != null)
		{
			//response.getWriter().print(request.getParameter("ids"));
			int ok = padao.deletePatient(Integer.parseInt(request.getParameter("ids")));
			List<Patient> liste = new ArrayList<Patient>();
			liste = padao.listPatient();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("/view/patient/list.jsp")
				.forward(request, response);
			
		}
		if(request.getParameter("choix") != null)
		{
			switch(request.getParameter("choix").toString().charAt(0))
			{
				case 'a':
						request.getRequestDispatcher("/view/patient/add.jsp")
										.forward(request, response);
					break;
				case 'l':
						List<Patient> liste = new ArrayList<Patient>();
						liste = padao.listPatient();
						request.setAttribute("liste", liste);
						request.getRequestDispatcher("/view/patient/list.jsp")
										.forward(request, response);
					break;
				default:
					
					break;
			}
		}
		else
		{
			request.getRequestDispatcher("/view/patient/index.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Patient pa;
		
		
		 int ok = 0;
		 pa = new Patient(0,nom,prenom);
		try 
		{
		 ok = padao.addPatient(pa);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(ok != 0)
		{
			request.setAttribute("ajout", "succes");
		}
		else
		{
			request.setAttribute("ajout", "echec");
		}
		request.getRequestDispatcher("view/patient/add.jsp")
				.forward(request, response);
			
	}

}
