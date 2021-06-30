package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.dao.IEnseignantDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class EnseignantDaoImpl extends HibernateSpringGenericDaoImpl<Enseignant,Long> implements IEnseignantDao {
	
	public EnseignantDaoImpl() {
		super(Enseignant.class);
	}

}
