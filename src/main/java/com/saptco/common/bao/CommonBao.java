package com.saptco.common.bao;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CommonBao extends AuthenticationManager,UserDetailsService{
	
}
