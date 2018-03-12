package com.cours.entities;

public class Medecin {
	private int idm;
	private String nomM;
	private String prenomM;
	private String telM;
	
	public Medecin()
	{
		
	}
	
	public Medecin(int idm, String nomM, String prenomM, String telM) {
		this.idm = idm;
		this.nomM = nomM;
		this.prenomM = prenomM;
		this.telM = telM;
	}

	public int getIdm() {
		return idm;
	}

	public void setIdm(int idm) {
		this.idm = idm;
	}

	public String getNomM() {
		return nomM;
	}

	public void setNomM(String nomM) {
		this.nomM = nomM;
	}

	public String getPrenomM() {
		return prenomM;
	}

	public void setPrenomM(String prenomM) {
		this.prenomM = prenomM;
	}

	public String getTelM() {
		return telM;
	}

	public void setTelM(String telM) {
		this.telM = telM;
	}
	
	
}
