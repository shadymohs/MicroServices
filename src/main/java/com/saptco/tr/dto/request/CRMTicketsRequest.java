package com.saptco.tr.dto.request;

public class CRMTicketsRequest {

	private String ticketNumber;
	private String saptcoPNR;
	private String userName;
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getSaptcoPNR() {
		return saptcoPNR;
	}
	public void setSaptcoPNR(String saptcoPNR) {
		this.saptcoPNR = saptcoPNR;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
