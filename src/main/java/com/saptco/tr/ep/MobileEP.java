package com.saptco.tr.ep;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saptco.common.bao.CommonBao;
import com.saptco.tr.bao.TRBao;
import com.saptco.tr.dto.response.MobileSystemConfigDto;

@RestController
@RequestMapping("/TR/mobile")
public class MobileEP {
	
	@Autowired
	private TRBao tRBao;
	
	@Autowired
	private CommonBao commonBao;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@GetMapping(value = "/systemConfig", produces = "application/json")
	public ResponseEntity<?> systemConfig(@RequestHeader("authorization") String authzHeader) throws Exception{
		if (authzHeader != null && authzHeader.toLowerCase().startsWith("basic")) {
		    // Authorization: Basic base64credentials
		    String base64Credentials = authzHeader.substring("Basic".length()).trim();
		    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
		    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
		    // credentials = username:password
		    final String[] values = credentials.split(":", 2);
			MobileSystemConfigDto systemConfig = new MobileSystemConfigDto();
			try {
				List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("Mobile_systemConfig");
				commonBao.authenticate(new UsernamePasswordAuthenticationToken(values[0],
						values[1],grantedAuths));
				systemConfig = tRBao.getMobileSystemConfig();
				return ResponseEntity.ok(systemConfig);
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}catch (Exception e) {
				logger.error(e);
				throw new Exception("invalid_data",e);
			}
	    }
		throw new Exception("bad_request");
	}
	
}
