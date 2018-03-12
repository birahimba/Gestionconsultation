package com.cours.entities;

import java.util.Date;

public class Consultation {
	private int idc;
	private String libC;
	private Date dateC; 
	private Patient idP;
	private Medecin idM;
	
	public Consultation()
	{
		
	}

	public Consultation(int idc, String libC, Date dateC, Patient idP, Medecin idM) {
		this.idc = idc;
		this.libC = libC;
		this.dateC = dateC;
		this.idP = idP;
		this.idM = idM;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getLibC() {
		return libC;
	}

	public void setLibC(String libC) {
		this.libC = libC;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public Patient getIdP() {
		return idP;
	}

	public void setIdP(Patient idP) {
		this.idP = idP;
	}

	public Medecin getIdM() {
		return idM;
	}

	public void setIdM(Medecin idM) {
		this.idM = idM;
	}
	
	
}
