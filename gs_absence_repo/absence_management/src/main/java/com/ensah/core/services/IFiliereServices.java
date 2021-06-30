package com.ensah.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Niveau;

public interface IFiliereServices {

    public Long addFiliere(Filiere o);
	
	public void updateFiliere(Filiere o);
	
	public void deleteFiliere(Long id);
	
	public List<Filiere> getAllFiliere();
	
	public Filiere getFiliereById(Long id);

	
 public List<Niveau> getNiveauxByIdFiliere(Long id) ;
	

	
}
