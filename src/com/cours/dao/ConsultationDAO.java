package com.cours.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cours.entities.Consultation;
import com.cours.entities.Medecin;
import com.cours.entities.Patient;

public class ConsultationDAO {

		private ResultSet rs;
		private int ok;
		private DB db;
		
		public int addConsultation(Consultation c)
		{
			String sql = "INSERT INTO consultation VALUES(null,?,?,?,?)";
			try
			{
				db = new DB();
				db.initPrepareStament(sql);
				db.getPstm().setString(1, c.getLibC());
				db.getPstm().setDate(2, (Date) c.getDateC());
				db.getPstm().setInt(3, c.getIdP().getIdp());
				db.getPstm().setInt(4, c.getIdM().getIdm());
				ok = db.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ok;
		}
		
		public int updateConsultation(Consultation c) 
		{	
			String sql = "UPDATE consultation SET libC=?,dateC=?,idP=?,idM=? WHERE idc=?";
			try
			{
				db = new DB();
				db.initPrepareStament(sql);
				db.getPstm().setString(1, c.getLibC());
				db.getPstm().setDate(2,(Date)c.getDateC());
				db.getPstm().setInt(3, c.getIdP().getIdp());
				db.getPstm().setInt(4, c.getIdM().getIdm());
				db.getPstm().setInt(5, c.getIdc());
				ok = db.executeUpdate();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();		
			}
			return ok;
		}
		
		public int deleteConsultation(int i) 
		{
			String sql = "DELETE FROM  consultation WHERE idc=?";
			try
			{
				db = new DB();
				db.initPrepareStament(sql);
				db.getPstm().setInt(1, i);
				db.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ok;
		}
		public List<Consultation> listConsultaion() 
		{
			String sql = "SELECT * FROM consultation";
			List<Consultation> listeC = new ArrayList<Consultation>();
			try
			{
				db = new DB();
				db.initPrepareStament(sql);
				rs = db.executeSelect();
				while(rs.next())
				{
					Consultation cons = new Consultation();
					cons.setIdc(rs.getInt(1));
					cons.setLibC(rs.getString(2));
					cons.setDateC(rs.getDate(3));
					
					Patient pat = new Patient();
					pat.setIdp(rs.getInt(4));
					
					cons.setIdP(pat);
					
					Medecin med = new Medecin();
					med.setIdm(rs.getInt(5));
					
					cons.setIdM(med);
					
					listeC.add(cons);
				}
					
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return listeC;
		}
		
		public Consultation getConsultationById(int i)
		{
			String sql = "SELECT * FROM consultation WHERE idc = ?";
			Consultation cons = new Consultation();
			try
			{
				db = new DB();
				db.initPrepareStament(sql);
				db.getPstm().setInt(1, i);
				rs = db.executeSelect();
				while(rs.next())
				{
					cons.setIdc(rs.getInt(1));
					cons.setLibC(rs.getString(2));
					cons.setDateC(rs.getDate(3));
					
					Patient p = new Patient();
					p.setIdp(rs.getInt(4));
					cons.setIdP(p);
					
					Medecin m = new Medecin();
					m.setIdm(rs.getInt(5));
					cons.setIdM(m);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return cons;
		}
		
}
