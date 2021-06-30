package com.ensah.core.services;

import java.util.List;
import java.util.Set;

import com.ensah.core.bo.Niveau;

public interface INiveauServices {

	
	public void updateNiveau(Niveau o);
	public void updateNiveau(Niveau o,Long idFiliere);
	public void addNiveau(Niveau o,Long idFiliere);
	public void deleteNiveau(Long id);
	public void addNiveau(Niveau o) ;
	public Niveau getNiveauById(Long id);
	public Niveau getNiveauByFiliereId(Long id,Long idFiliere);
	

	public List<Niveau> getAllNiveaux();
	
}
