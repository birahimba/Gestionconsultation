package com.cours.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.dao.MedcinDAO;
import com.cours.entities.Medecin;

/**
 * Servlet implementation class MedecinServ
 */
@WebServlet("/MedecinServ")
public class MedecinServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int ok;
	private Medecin med;
	private MedcinDAO mdao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedecinServ() {
    	mdao = new MedcinDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().println("Papa Samba");
		if(request.getParameter("choix") != null)
		{
			switch(request.getParameter("choix").toString().charAt(0))
			{
				case 'a':
						request.getRequestDispatcher("/view/medecin/add.jsp")
								.forward(request, response);
					break;
				case 'l':
						List<Medecin> liste = new ArrayList<Medecin>();
						liste = mdao.listMedecin();
						request.setAttribute("liste", liste);
						request.getRequestDispatcher("/view/medecin/list.jsp")
								.forward(request, response);
					break;
				default:
					
					break;
			}
		}
		else
		{
			request.getRequestDispatcher("/view/medecin/index.jsp")
				.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("env") != null)
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("telephone");
			med = new Medecin(0,nom,prenom,tel);
			
			try
			{
				ok = mdao.addMedcin(med);
			}
			catch(Exception e)
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
			request.getRequestDispatcher("/view/medecin/add.jsp")
				.forward(request, response);
		}
		
		if(request.getParameter("modif") != null)
		{
			
		}
		
	}

}
