package com.ensah.core.web.models;

import java.util.List;


import com.ensah.core.bo.Absence;

public class EnseignantModel extends PersonModel {
	
	private String specialite;


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	private List<Absence> absencesMarquees;


	public String getSpecialite() {
		return specialite;
	}


	public List<Absence> getAbsencesMarquees() {
		return absencesMarquees;
	}

	
	
}
