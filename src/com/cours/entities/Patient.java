package com.cours.entities;

public class Patient {
	private int idp;
	private String nomP;
	private String prenomP;
	
	public Patient()
	{
		
	}

	public Patient(int idp, String nomP, String prenomP) {
		this.idp = idp;
		this.nomP = nomP;
		this.prenomP = prenomP;
	}

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getPrenomP() {
		return prenomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}
	
	
	

}
