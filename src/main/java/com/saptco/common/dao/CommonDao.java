package com.saptco.common.dao;

import java.util.List;

import com.saptco.common.hbm.ServicesAuthentication;

public interface CommonDao {

	public Boolean validateUser(ServicesAuthentication serviceObj) throws Exception;

	public List<String> validateUserByName(String userName) throws Exception;
	
}
