package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Module;
public interface IModuleServices {

	
	
	
	public void addModule(Module o,Long idNiveau);
	
	public void update(Module o);
	
	public void deleteModule(Long id);
	
	public Module getModuleById(Long id);
	

	
	public List<Module> getModulesByNiveauId(Long idNiveau) ;
	public Module getModuleByNiveauId(Long idNiveau,Long idModule);
	public void removeAll();
	
}
