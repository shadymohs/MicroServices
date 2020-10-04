package com.saptco.tr.dao;

import com.saptco.tr.dto.response.CRMCustomersResponse;
import com.saptco.tr.dto.response.CRMTicketsResponse;
import com.saptco.tr.dto.response.MobileSystemConfigDto;

public interface TRDao {	

	public MobileSystemConfigDto getMobileSystemConfig() throws Exception;

	public CRMTicketsResponse getCRMTRData(String saptcoPNR, String ticketNumber) throws Exception;

	public CRMCustomersResponse getCRMTRCustomers(String fromDate, String toDate) throws Exception;
	
}
