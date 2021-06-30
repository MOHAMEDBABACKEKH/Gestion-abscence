package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.INiveauDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;


@Repository
public class INiveauDaoImpl extends HibernateSpringGenericDaoImpl<Niveau,Long>implements INiveauDao{
	
	
	public INiveauDaoImpl() {
		super(Niveau.class);
	}

}
