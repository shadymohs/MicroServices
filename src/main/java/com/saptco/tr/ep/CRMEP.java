package com.saptco.tr.ep;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saptco.common.bao.CommonBao;
import com.saptco.tr.bao.TRBao;
import com.saptco.tr.dto.request.CRMCustomersRequest;
import com.saptco.tr.dto.request.CRMTicketsRequest;
import com.saptco.tr.dto.response.CRMCustomersResponse;
import com.saptco.tr.dto.response.CRMTicketsResponse;

@RestController
@RequestMapping("/TR/CRM")
public class CRMEP {
	
	@Autowired
	private TRBao tRBao;
	
	@Autowired
	private CommonBao commonBao;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@GetMapping(value = "/getTicketsByBNRTicket", produces = "application/json")
	public ResponseEntity<?> getTicketsByBNRTicket(@RequestBody CRMTicketsRequest request) throws Exception{
		try {
			if((request.getSaptcoPNR() != null && !request.getSaptcoPNR().isEmpty()) ||
					(request.getTicketNumber() != null && !request.getTicketNumber().isEmpty())) {
				UserDetails userData = commonBao.loadUserByUsername(request.getUserName());
				Boolean isAuth = false;
				for(GrantedAuthority auth : userData.getAuthorities()){
					if(auth.getAuthority().equals("CRMTRTickets")) {
						isAuth = true;
						break;
					}
				}
				if(!isAuth)
					throw new UsernameNotFoundException("Invalid user");
				CRMTicketsResponse responseList = tRBao.getCRMTRData(request.getSaptcoPNR(), request.getTicketNumber());
				return ResponseEntity.ok(responseList);
			}
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}catch (Exception e) {
			logger.error(e);
			throw new Exception("invalid_data",e);
		}
		throw new Exception("bad_request");
	}
	
	@GetMapping(value = "/getCustomersByPeriod", produces = "application/json")
	public ResponseEntity<?> getCustomersByPeriod(@RequestBody CRMCustomersRequest request) throws Exception{
		try {
			if(request.getFromDate() != null && !request.getFromDate().isEmpty() &&
					request.getToDate() != null && !request.getToDate().isEmpty()) {
				UserDetails userData = commonBao.loadUserByUsername(request.getUserName());
				Boolean isAuth = false;
				for(GrantedAuthority auth : userData.getAuthorities()){
					if(auth.getAuthority().equals("CRMTRCustomers")) {
						isAuth = true;
						break;
					}
				}
				if(!isAuth)
					throw new UsernameNotFoundException("Invalid user");
				CRMCustomersResponse responseList = tRBao.getCRMTRCustomers(request.getFromDate(), request.getToDate());
				return ResponseEntity.ok(responseList);
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
