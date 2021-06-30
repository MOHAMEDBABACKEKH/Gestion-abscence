package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Enseignant;

public interface IEnseignantServices {
	
	public void addEnseigant(Enseignant o);
	
	public void deleteEnseignant(Long id);
	
	public void updateEnseignant(Enseignant o);
	
	public List<Enseignant> getAll();

}
