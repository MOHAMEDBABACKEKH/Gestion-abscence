package com.ensah.core.web.models;



import com.ensah.core.bo.Module;

public class MatiereModel {

	private Long idMatiere;

	private String nom;

	private String code;


	private Module module;
	
	
	
	public MatiereModel() {}
	

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
