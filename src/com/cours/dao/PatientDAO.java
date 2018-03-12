package com.cours.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cours.entities.Patient;

public class PatientDAO {
	private DB db;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int ok;
	
	public int addPatient(Patient p)
	{
		String sql = "INSERT INTO patient VALUES(null,?,?)";
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setString(1, p.getNomP());
			db.getPstm().setString(2, p.getPrenomP());
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	
	public int updatePatient(Patient p)
	{
		String sql = "UPDATE patient SET nomP=?,prenomP=? WHERE idp=? ";
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setString(1, p.getNomP());
			db.getPstm().setString(2, p.getPrenomP());
			db.getPstm().setInt(3, p.getIdp());
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		return ok;
	}
	
	public int deletePatient(int id)
	{
		String sql = "DELETE FROM patient WHERE idp=?";
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setInt(1, id);
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	
	public List<Patient> listPatient()
	{
		String sql = "select * from patient";
		List<Patient> listeP = new ArrayList<>(); 
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			rs = db.executeSelect();
			while(rs.next())
			{
				Patient p = new Patient();
				p.setIdp(rs.getInt(1));
				p.setNomP(rs.getString(2));
				p.setPrenomP(rs.getString(3));
				listeP.add(p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeP;
	}
	public Patient getPatientById(int id)
	{
		
		String sql = "SELECT * FROM patient WHERE idp = ?";
		Patient p = new Patient();
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next())
			{
				p.setIdp(rs.getInt(1));
				p.setNomP(rs.getString(2));
				p.setPrenomP(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  p;
	}
}
