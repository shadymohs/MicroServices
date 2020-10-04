package com.saptco.common.ep;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.saptco.common.bao.CommonBao;
import com.saptco.common.config.JwtResponse;
import com.saptco.common.config.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/SAPTCO")
public class SAPTCOEP {

	@Autowired
	private CommonBao commonBao;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createAuthenticationToken(@RequestHeader("authorization") String authzHeader) throws Exception {
		try {
			if (authzHeader != null && authzHeader.toLowerCase().startsWith("basic")) {
			    // Authorization: Basic base64credentials
			    String base64Credentials = authzHeader.substring("Basic".length()).trim();
			    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			    // credentials = username:password
			    final String[] values = credentials.split(":", 2);
				List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("authenticate");
				commonBao.authenticate(new UsernamePasswordAuthenticationToken(values[0],values[1],grantedAuths));
				final UserDetails userDetails = commonBao.loadUserByUsername(values[0]);
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new JwtResponse(token));
			}
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}catch (Exception e) {
			logger.error(e);
			throw new Exception("invalid_data",e);
		}
		throw new Exception("bad_request");
	}

}