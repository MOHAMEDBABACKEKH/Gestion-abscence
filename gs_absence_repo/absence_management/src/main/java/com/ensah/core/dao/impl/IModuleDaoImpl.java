package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.dao.IModuleDao;
import com.ensah.core.bo.Module;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class IModuleDaoImpl extends HibernateSpringGenericDaoImpl<Module,Long>implements IModuleDao {

	public IModuleDaoImpl() {
		super(Module.class);
		
	}

}
