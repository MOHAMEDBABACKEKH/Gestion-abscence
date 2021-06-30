package com.ensah.core.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.Module;
import com.ensah.core.dao.IMatiereDao;
import com.ensah.core.dao.IModuleDao;
import com.ensah.core.services.IMatiereServices;

@Service
@Transactional
public class MatiereServicesImpl implements IMatiereServices {
	
	@Autowired
	private IMatiereDao matieredao;

	
	@Autowired
	private IModuleDao moduledao;


	@Override
	public void deleteMatiere(Long id) {
		
		matieredao.delete(id);
	}

	@Override
	public void updateMatiere(Matiere o) {
	
		matieredao.update(o);
		
	}

	@Override
	public List<Matiere> getAllMatieres() {
		
		return matieredao.getAll();
	}

	@Override
	public List<Matiere> getMatiereByIdModule(Long id) {
		return moduledao.findById(id).getMatieres();
	}

	@Override
	public void addMatiere(Matiere o, Long id) {
		
		
		Module module= moduledao.findById(id);
		o.setModule(module);
		matieredao.create(o);
	}

	@Override
	public Matiere getMatiereById(Long id) {
		
		return matieredao.findById(id);
	}

	@Override
	public Matiere getMatiereByModuleId(Long IdMatiere, Long idModule) {
		
		Module module =moduledao.findById(idModule);
		Matiere matiere=matieredao.findById(IdMatiere);
		List<Matiere> matieres=module.getMatieres();
		for(int i=0;i<matieres.size();i++) {
			if(matieres.get(i)==matiere)
	    		return matiere;
	    }
		
		return null;
	}

	
	
}
