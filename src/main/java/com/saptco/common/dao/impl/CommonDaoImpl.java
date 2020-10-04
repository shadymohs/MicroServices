package com.saptco.common.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Repository;

import com.saptco.common.dao.CommonDao;
import com.saptco.common.hbm.ServicesAuthentication;

@Repository("commonDao")
public class CommonDaoImpl implements CommonDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Boolean validateUser(ServicesAuthentication serviceObj) {
		String query = "select CASE WHEN(count(s) = 0) THEN 0 ELSE 1 END from ServicesAuthentication s where s.code = ?1 and s.userName = ?2 and s.password = ?3";
		return BooleanUtils.toBoolean((Integer)entityManager.createQuery(query,Integer.class)
			      .setParameter(1, serviceObj.getCode())
			      .setParameter(2, serviceObj.getUserName())
			      .setParameter(3, serviceObj.getPassword())
			      .getSingleResult());
	}

	@Override
	public List<String> validateUserByName(String userName) throws Exception {
		String query = "select s.code from ServicesAuthentication s where s.userName = ?1";
		return entityManager.createQuery(query,String.class)
			      .setParameter(1, userName)
			      .getResultList();
	}
}
