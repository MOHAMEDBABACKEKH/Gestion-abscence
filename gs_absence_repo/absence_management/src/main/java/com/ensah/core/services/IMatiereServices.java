package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Matiere;

public interface IMatiereServices {

	
	public void addMatiere(Matiere o ,Long id);
	
	public void deleteMatiere(Long id);
	
	public void updateMatiere(Matiere o);
	
	public Matiere getMatiereByModuleId(Long IdMatiere,Long idModule);
	public Matiere getMatiereById(Long id);
	public List<Matiere> getMatiereByIdModule(Long idMatiere);
	public List<Matiere> getAllMatieres();


	
}
