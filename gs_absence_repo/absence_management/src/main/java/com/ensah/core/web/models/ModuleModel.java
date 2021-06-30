package com.ensah.core.web.models;


import java.util.List;
import java.util.Set;

import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.Niveau;

public class ModuleModel {

	
	private Long idModule;

	private String titre;

	private String code;

	private Set<Matiere> matieres;

	
	private Niveau niveau;
	
	
	public ModuleModel() {}


	public Long getIdModule() {
		return idModule;
	}


	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Set<Matiere> getMatieres() {
		return matieres;
	}


	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	
}
