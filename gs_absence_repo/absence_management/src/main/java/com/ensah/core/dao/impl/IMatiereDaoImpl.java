package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Matiere;
import com.ensah.core.dao.IMatiereDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;


@Repository
public class IMatiereDaoImpl extends HibernateSpringGenericDaoImpl<Matiere,Long>implements IMatiereDao {
	
	public IMatiereDaoImpl() {
		super(Matiere.class);
	}

}
