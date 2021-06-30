package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.Module;
import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.IModuleDao;
import com.ensah.core.dao.INiveauDao;
import com.ensah.core.services.IModuleServices;

@Service
@Transactional
public class ModuleServicesImpl  implements IModuleServices{

	
	@Autowired
	private IModuleDao moduledao;
	
	@Autowired
	private INiveauDao niveaudao;;
	
	

	@Override
	public void addModule(Module o,Long idNiveau) {
		
		
		Niveau n=niveaudao.findById(idNiveau);
		o.setNiveau(n);
		moduledao.create(o);
		
	}

	@Override
	public void update(Module o) {
		
		moduledao.update(o);
		
	}

	@Override
	public void deleteModule(Long id) {
		moduledao.delete(id);
	}

	@Override
	public void removeAll() {
	
		
	}

	@Override
	public List<Module> getModulesByNiveauId(Long idNiveau) {
		return niveaudao.findById(idNiveau).getModules();
	}

	@Override
	public Module getModuleById(Long id) {
	
		return moduledao.findById(id);
	}

	@Override
	public Module getModuleByNiveauId(Long idNiveau, Long idModule) {
		
		Niveau n=niveaudao.findById(idNiveau);
		Module m=moduledao.findById(idModule);
		List<Module> modules=n.getModules();
		
		for(int i=0;i<modules.size();i++) {
			if(modules.get(i)==m)return m;
		}
		 
		return null;
	}

	
	public List<Matiere> getMatieresByModuleId(Long idModule) {
		
		
		return moduledao.findById(idModule).getMatieres();
		
		
	}


}
