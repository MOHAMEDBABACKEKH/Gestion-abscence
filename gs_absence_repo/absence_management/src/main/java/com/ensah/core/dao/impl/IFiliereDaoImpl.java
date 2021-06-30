package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;


import com.ensah.core.bo.Filiere;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class IFiliereDaoImpl  extends HibernateSpringGenericDaoImpl<Filiere,Long>implements IFiliereDao{

	
	public IFiliereDaoImpl() {
	super(Filiere.class);}
}
