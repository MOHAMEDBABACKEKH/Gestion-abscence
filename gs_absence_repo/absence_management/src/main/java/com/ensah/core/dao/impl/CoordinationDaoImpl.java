package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Coordination;
import com.ensah.core.dao.ICoordinationDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
@Repository
public class CoordinationDaoImpl extends HibernateSpringGenericDaoImpl<Coordination,Long> implements ICoordinationDao{

	
	public CoordinationDaoImpl() { super(Coordination.class);}
}
