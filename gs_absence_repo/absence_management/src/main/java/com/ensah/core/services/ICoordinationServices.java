package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Module;
public interface ICoordinationServices {

	

	public List <Filiere>getAllFiliere(); 
	
    public List<Module> getAllModules();
	
	public Module getModuleById(Long id);
	
	public Filiere getFiliereById(Long id);
	
	 public void affecterCoordonateur(Coordination o,Long idEneignant,Long idFiliere); 
	
	
	  public void removeCoordonateur(Long id);
	  
	  public void updateCoordination(Coordination o);
	 
	
	public List <Enseignant>getAllEnseignant();
	
	
	
}
