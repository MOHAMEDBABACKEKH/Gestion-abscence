package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.services.IFiliereServices;

@Service
@Transactional
public class FiliereServicesImpl implements IFiliereServices {
	
	@Autowired
	private IFiliereDao filieredao;

	
	
	public Long addFiliere(Filiere o) {
		
		 return filieredao.create(o);
	}

	
	public void updateFiliere(Filiere o) {
		
		filieredao.update(o);
	}

	@Override
	public void deleteFiliere(Long id) {
		
		filieredao.delete(id);
		
	}

	@Override
	public List<Filiere> getAllFiliere() {
		
		return filieredao.getAll();
		
	}

	@Override
	public Filiere getFiliereById(Long id) {
		
		return filieredao.findById(id);
	}
	@Override
    public List<Niveau> getNiveauxByIdFiliere(Long id) {
		
		return filieredao.findById(id).getNiveaux();
	}


	
}