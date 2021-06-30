package com.ensah.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.dao.IEnseignantDao;
import com.ensah.core.services.IEnseignantServices;


@Service
@Transactional
public class EnseignantServicesImpl implements IEnseignantServices {

	
	@Autowired
	private IEnseignantDao enseigantdao;
	
	@Override
	public void addEnseigant(Enseignant o) {
	
    enseigantdao.create(o);		
	}

	@Override
	public void deleteEnseignant(Long id) {
	 enseigantdao.delete(id);
	}

	@Override
	public void updateEnseignant(Enseignant o) {
		
		enseigantdao.update(o);
	}

	@Override
	public List<Enseignant> getAll() {
		
		return enseigantdao.getAll();
	}

}
