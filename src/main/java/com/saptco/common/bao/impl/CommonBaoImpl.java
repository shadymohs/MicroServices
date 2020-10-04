package com.saptco.common.bao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.saptco.common.bao.CommonBao;
import com.saptco.common.dao.CommonDao;
import com.saptco.common.hbm.ServicesAuthentication;


@Service("commonBao")
public class CommonBaoImpl implements CommonBao{

	@Autowired
	private CommonDao commonDao;
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		ServicesAuthentication serviceObj = new ServicesAuthentication();
		serviceObj.setCode(((SimpleGrantedAuthority)authentication.getAuthorities().toArray() [0]).getAuthority());
		serviceObj.setUserName(authentication.getPrincipal().toString());
		serviceObj.setPassword(authentication.getCredentials().toString());

        try {
			if(!commonDao.validateUser(serviceObj))
				throw new BadCredentialsException("1000");
		} catch (Exception e) {
			throw new BadCredentialsException("1000");
		}
        
        return new UsernamePasswordAuthenticationToken(serviceObj.getUserName(), null, null);
    }
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuths = null;
		try {
			List<String> privillegeList = commonDao.validateUserByName(userName);
			if(privillegeList == null || privillegeList.isEmpty())
				throw new UsernameNotFoundException("Invalid user");
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", privillegeList));
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Invalid user");
		}
		return new User(userName, "saptco", grantedAuths);
	}
	
}
