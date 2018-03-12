package com.cours.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class DB {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int ok;
	
	public void getConnexion()
	{
		String url = "jdbc:mysql://localhost:3306/gestionconsultation";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void initPrepareStament(String sql)
	{	getConnexion();
		try
		{
			pstm = con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSelect ()
	{
		getConnexion();
		try
		{
			rs =  pstm.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public int executeUpdate()
	{	
		getConnexion();
		try
		{
			ok = pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	public PreparedStatement getPstm()
	{
		return pstm;
	}
	
	
	

}
