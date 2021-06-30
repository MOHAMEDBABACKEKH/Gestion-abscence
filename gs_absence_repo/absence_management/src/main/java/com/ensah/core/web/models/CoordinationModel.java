package com.ensah.core.web.models;

import java.util.Date;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Filiere;

public class CoordinationModel {

	private Long idCoordination;

	private Date dateDebut;

	private Date dateFin;

	public Enseignant coordonateur;
	
	public Filiere filiere;

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Long getIdCoordination() {
		return idCoordination;
	}

	public void setIdCoordination(Long idCoordination) {
		this.idCoordination = idCoordination;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Enseignant getCoordonateur() {
		return coordonateur;
	}

	public void setCoordonateur(Enseignant coordonateur) {
		this.coordonateur = coordonateur;
	}
	
}
