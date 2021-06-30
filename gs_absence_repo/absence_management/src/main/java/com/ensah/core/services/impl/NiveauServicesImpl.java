package com.ensah.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.dao.INiveauDao;
import com.ensah.core.services.INiveauServices;

@Service
@Transactional

public class NiveauServicesImpl  implements INiveauServices{

	@Autowired
	private INiveauDao niveaudao;

	@Autowired
	private IFiliereDao filieredao;
	
	
	@Override
	public void updateNiveau(Niveau o,Long idFiliere) {
		
		Filiere filiere=filieredao.findById(idFiliere);
	    o.setFiliere(filiere);
		niveaudao.update(o);
		
	}

	@Override

	public void addNiveau(Niveau o,Long idFiliere) {
		
		Filiere filiere=filieredao.findById(idFiliere);
		

		  
		  o.setFiliere(filiere);
		  niveaudao.create(o);
		
	}
  public void addNiveau(Niveau o) {
		
		
		niveaudao.create(o);
		
	}
  
	@Override
	public void deleteNiveau(Long id) {
		
		niveaudao.delete(id);
		
	}

	@Override
	public List<Niveau> getAllNiveaux() {
		
		return niveaudao.getAll();
	}

	@Override
	public Niveau getNiveauById(Long id) {
		
		return niveaudao.findById(id);
	}

	@Override
	public void updateNiveau(Niveau o) {
		niveaudao.update(o);
		
	}

	@Override
	public Niveau getNiveauByFiliereId(Long id, Long idFiliere) {
		
		
		Filiere filiere=filieredao.findById(idFiliere);
	   List<Niveau> n=filiere.getNiveaux();
	   Niveau nive=niveaudao.findById(id);
	    for(int i=0;i<n.size();i++) {
	    	if(n.get(i)==nive)
	    		return nive;
	    }
		
		return null;
	}

}
