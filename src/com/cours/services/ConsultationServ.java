package com.cours.services;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.dao.ConsultationDAO;
import com.cours.dao.MedcinDAO;
import com.cours.dao.PatientDAO;
import com.cours.entities.Consultation;
import com.cours.entities.Medecin;
import com.cours.entities.Patient;

/**
 * Servlet implementation class ConsultationServ
 */
@WebServlet("/ConsultationServ")
public class ConsultationServ extends HttpServlet {
	private int ok;
	private Consultation cons;
	private ConsultationDAO cdao;
	private MedcinDAO mdao;
	private PatientDAO pdao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultationServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Pour la modification
		if(request.getParameter("idm") != null)
		{
			int i = Integer.parseInt(request.getParameter("idm"));
			Consultation c = new Consultation();
			c = cdao.getConsultationById(i);
			request.setAttribute("consultation", c);
			
			List<Patient> listeP = new ArrayList<Patient>();
			listeP = pdao.listPatient();
			request.setAttribute("listeP", listeP);
			
			List<Medecin> listeM = new ArrayList<Medecin>();
			listeM = mdao.listMedecin();
			request.setAttribute("listeM", listeM);
			
			request.getRequestDispatcher("/view/consultation/update.jsp")
						.forward(request, response);
		}
		//la suppression
		if(request.getParameter("ids") != null)
		{
			int i = Integer.parseInt(request.getParameter("ids"));
			//response.getWriter().print(i);
			cdao.deleteConsultation(i);
			List<Consultation> liste = new ArrayList<Consultation>();
			liste = cdao.listConsultaion();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("/view/consultation/list.jsp")
				.forward(request, response);
		}

			
		if(request.getParameter("choix") != null)
		{
			switch(request.getParameter("choix").toString().charAt(0))
			{
				case 'a':
					List<Patient> listeP = new ArrayList<Patient>();
					listeP = pdao.listPatient();
					request.setAttribute("listeP", listeP);
					
					List<Medecin> listeM = new ArrayList<Medecin>();
					listeM = mdao.listMedecin();
					request.setAttribute("listeM", listeM);
					
					request.getRequestDispatcher("/view/consultation/add.jsp")
						.forward(request, response);
					break;
				case 'l':
					List<Consultation> liste = new ArrayList<Consultation>();
					liste = cdao.listConsultaion();
					request.setAttribute("liste", liste);
					request.getRequestDispatcher("/view/consultation/list.jsp")
						.forward(request, response);
					break;
				default:
					break;
			}
		}
		else
		{
			request.getRequestDispatcher("/view/consultation/index.jsp")
					.forward(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
		cdao = new ConsultationDAO();
		mdao = new MedcinDAO();
		pdao = new PatientDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("env") != null)
		{
			String libelle = request.getParameter("libelle");
			Date date = Date.valueOf(request.getParameter("date"));
			int patient = Integer.parseInt(request.getParameter("patient"));
			int medecin = Integer.parseInt(request.getParameter("medecin"));
			
			Patient p = new Patient();
			p.setIdp(patient);
			
			Medecin m =new Medecin();
			m.setIdm(medecin);
			
			cons = new Consultation(0,libelle,date,p,m);
				
			try
			{
				ok = cdao.addConsultation(cons);
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
			request.getRequestDispatcher("/view/consultation/add.jsp")
				.forward(request, response);

		}
				
		if(request.getParameter("modif") != null)
		{
			int id = Integer.parseInt(request.getParameter("idc"));
			String libelle = request.getParameter("libelle");
			Date date = Date.valueOf(request.getParameter("date"));
			int patient = Integer.parseInt(request.getParameter("patient"));
			int medecin = Integer.parseInt(request.getParameter("medecin"));
			
			Patient p =new Patient();
			p.setIdp(patient);
			
			Medecin m = new Medecin();
			m.setIdm(medecin);
			
			Consultation cns = new Consultation(id,libelle,date,p,m);
			cdao.updateConsultation(cns);
			List<Consultation> liste = new ArrayList<Consultation>();
			liste = cdao.listConsultaion();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("/view/consultation/list.jsp")
				.forward(request, response);
			
			
		}
	}
	
}
