package com.ensah.core.web.models;



import java.util.List;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.Module;

public class NiveauModel {

	
	private Long idNiveau;

	private String alias;

	private String titre;

	private List<Module> modules;

	
	private List<Inscription> inscriptions;
	
	private Filiere filiere;

	public NiveauModel() {}


	public Long getIdNiveau() {
		return idNiveau;
	}


	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public List<Module> getModules() {
		return modules;
	}


	public void setModules(List<Module> modules) {
		this.modules = modules;
	}


	public List<Inscription> getInscriptions() {
		return inscriptions;
	}


	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	
  
}
