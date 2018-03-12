package com.cours.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cours.entities.Medecin;
import com.cours.entities.Patient;

public class MedcinDAO {
	private DB db;
	private ResultSet rs;
	private int ok;
	
	public int addMedcin(Medecin m)
	{
		String sql = "INSERT INTO medecin VALUES (null,?,?,?)";
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setString(1, m.getNomM());
			db.getPstm().setString(2, m.getPrenomM());
			db.getPstm().setString(3, m.getTelM());
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	
	public int updateMedecin(Medecin m)
	{
		String sql = "UPDATE medecin SET nomM=?,prenomM=?,telephone=? WHERE idm=?";
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setString(1, m.getNomM());
			db.getPstm().setString(2, m.getPrenomM());
			db.getPstm().setString(3, m.getTelM());
			db.getPstm().setInt(4, m.getIdm());
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	
	public int deleteMedecin(int i)
	{
		String sql = "DELETE FROM medecin WHERE idm=?";
		
		try
		{
			db = new DB();
			db.initPrepareStament(sql);
			db.getPstm().setInt(1, i);
			ok = db.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	
	public List<Medecin> listMedecin()
	{
		String sql = "select * from medecin";
		List<Medecin>listeM = new ArrayList<>();
		try
		{	db = new DB();
			db.initPrepareStament(sql);
			rs = db.executeSelect();
			while(rs.next())
			{
				Medecin m = new Medecin();
				m.setIdm(rs.getInt(1));
				m.setNomM(rs.getString(2));
				m.setPrenomM(rs.getString(3));
				m.setTelM(rs.getString(4));
				
				listeM.add(m);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeM;
	}
}
