package com.ensah.core.web.models;

import java.util.List;
import java.util.Set;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Niveau;

public class FiliereModel {

	
	private Long idFiliere;

	private String titreFiliere;

	private String codeFiliere;

	private int anneeaccreditation;

	private int anneeFinaccreditation;
	
	

	private List<Niveau> niveaux;
	

	public List<Coordination> periodeCoordination;
	
	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public List<Coordination> getPeriodeCoordination() {
		return periodeCoordination;
	}

	public void setPeriodeCoordination(List<Coordination> periodeCoordination) {
		this.periodeCoordination = periodeCoordination;
	}

	public FiliereModel() {}

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getTitreFiliere() {
		return titreFiliere;
	}

	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}

	public String getCodeFiliere() {
		return codeFiliere;
	}

	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}

	public int getAnneeaccreditation() {
		return anneeaccreditation;
	}

	public void setAnneeaccreditation(int anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}

	public int getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}

	public void setAnneeFinaccreditation(int anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}

	
	
}
