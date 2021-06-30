package com.ensah.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Module;
import com.ensah.core.dao.ICoordinationDao;
import com.ensah.core.dao.IEnseignantDao;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.dao.IModuleDao;
import com.ensah.core.services.ICoordinationServices;

@Service
@Transactional
public class CoordinationServicesImpl implements ICoordinationServices {

	@Autowired
	private IFiliereDao filieredao;
	
	@Autowired
	private IModuleDao moduledao;
	
	@Autowired
	private IEnseignantDao enseignantDao;
	
	@Autowired
	private ICoordinationDao coordinationdao;
	
	@Override
	public List<Filiere> getAllFiliere() {
		
		return filieredao.getAll();
	}

	@Override
	public List<Module> getAllModules() {
		return moduledao.getAll();
	}

	@Override
	public Module getModuleById(Long id) {
		
		return moduledao.findById(id);
	}

	@Override
	public Filiere getFiliereById(Long id) {
		
		return filieredao.findById(id);
	}
	 

	@Override
	public List<Enseignant> getAllEnseignant() {
		
		return enseignantDao.getAll();
	}

//	public void affecterCoordonateur(Coordination o,Long idEneignant) {
//		
//		 Enseignant ens=enseignantDao.findById(idEneignant);
//		 
//		 o.setCoordonateur(ens);
//		 
//		 coordinationdao.create(o);
//		 
//		 
//		
//	}


	public void removeCoordonateur(Long id) {
		
		coordinationdao.delete(id);
		
	}


	public void updateCoordination(Coordination o) {
		
		coordinationdao.update(o);
		
	}

	
	public void affecterCoordonateur(Coordination o, Long idEneignant, Long idFiliere) {
		
		Enseignant ens=enseignantDao.findById(idEneignant);
		
		Filiere filiere=filieredao.findById(idFiliere);
		
	     o.setCoordonateur(ens);
	     List<Coordination> coordinationList=new ArrayList<Coordination>();
	     coordinationList.add(o);
	     filiere.setPeriodeCoordination(coordinationList);
	     coordinationdao.create(o);
	}

	


	}
