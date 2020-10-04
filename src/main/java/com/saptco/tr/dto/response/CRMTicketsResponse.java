package com.saptco.tr.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.saptco.common.hbm.CRMTicketsBean;

public class CRMTicketsResponse {

	private List<CRMTicketsBean> ticketsList = new ArrayList<CRMTicketsBean>();
	private String errorCode;
	private String errorDesc;
	
	public List<CRMTicketsBean> getTicketsList() {
		return ticketsList;
	}
	public void setTicketsList(List<CRMTicketsBean> ticketsList) {
		this.ticketsList = ticketsList;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
}
