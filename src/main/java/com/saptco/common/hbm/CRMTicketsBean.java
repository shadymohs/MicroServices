package com.saptco.common.hbm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CRMTicketsBean {

	@Column(name = "SAPTCO_PNR")
	private String saptcoPNR;
	
	@Id
	@Column(name = "TICKET_NUMBER")
	private String ticketNumber;
	
	@Column(name = "TRIP_CODE")
	private String tripCode;
	
	@Column(name = "TRIP_TYPE_AR")
	private String tripTypeAr;
	
	@Column(name = "TRIP_TYPE_EN")
	private String tripTypeEn;
	
	@Column(name = "FROM_STATION_AR")
	private String fromStationAr;
	
	@Column(name = "FROM_STATION_EN")
	private String fromStationEn;
	
	@Column(name = "TO_STATION_AR")
	private String toStationAr;
	
	@Column(name = "TO_STATION_EN")
	private String toStationEn;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "TICKET_FARE")
	private BigDecimal ticketFare;
	
	@Column(name = "TAX_AMOUNT")
	private BigDecimal taxAmount;
	
	@Column(name = "TICKET_STATUS_AR_DESC")
	private String ticketStatusAr;
	
	@Column(name = "TICKET_STATUS_EN_DESC")
	private String ticketStatusEn;
	
	@Column(name = "PAYMENT_METHOD_AR_DESC")
	private String paymentMethodAr;
	
	@Column(name = "PAYMENT_METHOD_EN_DESC")
	private String paymentMethodEn;
	
	@Column(name = "ISSUE_DATE")
	private String issueDate;
	
	@Column(name = "TRIP_DATE")
	private String tripDate;
	
	@Column(name = "ID_TYPE_AR_DESC")
	private String idTypeAr;
	
	@Column(name = "ID_TYPE_EN_DESC")
	private String idTypeEn;
	
	@Column(name = "POI_NUMBER")
	private String poiNumber;
	
	@Column(name = "NATIONALITY_AR_DESC")
	private String nationalityAr;
	
	@Column(name = "NATIONALITY_EN_DESC")
	private String nationalityEn;
	
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "BUS_NUMBER")
	private String busNumber;
	
	@Column(name = "BUS_LOCATION")
	private String busLocation;
	
	@Column(name = "DRIVER1_NUMBER")
	private String driver1Number;
	
	@Column(name = "DRIVER1_NAME")
	private String driver1Name;
	
	@Column(name = "DRIVER1_NATIONALTY_AR")
	private String driver1NationalityAr;
	
	@Column(name = "DRIVER1_NATIONALTY_EN")
	private String driver1NationalityEn;
	
	@Column(name = "DRIVER2_NUMBER")
	private String driver2Number;
	
	@Column(name = "DRIVER2_NAME")
	private String driver2Name;
	
	@Column(name = "DRIVER2_NATIONALTY_AR")
	private String driver2NationalityAr;
	
	@Column(name = "DRIVER2_NATIONALTY_EN")
	private String driver2NationalityEn;
	
	@Column(name = "SDP_AR_DESC")
	private String sdpAr;
	
	@Column(name = "SDP_EN_DESC")
	private String sdpEn;
	
	@Column(name = "SDP_TYPE_AR_DESC")
	private String sdpTypeAr;
	
	@Column(name = "SDP_TYPE_EN_DESC")
	private String sdpTypeEn;
	
	@Column(name = "USER_NUMBER")
	private String userNumber;
	
	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	
	@Column(name = "UPDATED_USER_NAME")
	private String updatedUserName;
	
	@Column(name = "PAID_USER_NUMBER")
	private String paidByUserNumber;
	
	@Column(name = "PAID_USER_NAME")
	private String paidByUserName;
	
	public String getSaptcoPNR() {
		return saptcoPNR;
	}
	public void setSaptcoPNR(String saptcoPNR) {
		this.saptcoPNR = saptcoPNR;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTripCode() {
		return tripCode;
	}
	public void setTripCode(String tripCode) {
		this.tripCode = tripCode;
	}
	public String getTripTypeAr() {
		return tripTypeAr;
	}
	public void setTripTypeAr(String tripTypeAr) {
		this.tripTypeAr = tripTypeAr;
	}
	public String getTripTypeEn() {
		return tripTypeEn;
	}
	public void setTripTypeEn(String tripTypeEn) {
		this.tripTypeEn = tripTypeEn;
	}
	public String getFromStationAr() {
		return fromStationAr;
	}
	public void setFromStationAr(String fromStationAr) {
		this.fromStationAr = fromStationAr;
	}
	public String getFromStationEn() {
		return fromStationEn;
	}
	public void setFromStationEn(String fromStationEn) {
		this.fromStationEn = fromStationEn;
	}
	public String getToStationAr() {
		return toStationAr;
	}
	public void setToStationAr(String toStationAr) {
		this.toStationAr = toStationAr;
	}
	public String getToStationEn() {
		return toStationEn;
	}
	public void setToStationEn(String toStationEn) {
		this.toStationEn = toStationEn;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(BigDecimal ticketFare) {
		this.ticketFare = ticketFare;
	}
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getTicketStatusAr() {
		return ticketStatusAr;
	}
	public void setTicketStatusAr(String ticketStatusAr) {
		this.ticketStatusAr = ticketStatusAr;
	}
	public String getTicketStatusEn() {
		return ticketStatusEn;
	}
	public void setTicketStatusEn(String ticketStatusEn) {
		this.ticketStatusEn = ticketStatusEn;
	}
	public String getPaymentMethodAr() {
		return paymentMethodAr;
	}
	public void setPaymentMethodAr(String paymentMethodAr) {
		this.paymentMethodAr = paymentMethodAr;
	}
	public String getPaymentMethodEn() {
		return paymentMethodEn;
	}
	public void setPaymentMethodEn(String paymentMethodEn) {
		this.paymentMethodEn = paymentMethodEn;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getTripDate() {
		return tripDate;
	}
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
	public String getIdTypeAr() {
		return idTypeAr;
	}
	public void setIdTypeAr(String idTypeAr) {
		this.idTypeAr = idTypeAr;
	}
	public String getIdTypeEn() {
		return idTypeEn;
	}
	public void setIdTypeEn(String idTypeEn) {
		this.idTypeEn = idTypeEn;
	}
	public String getPoiNumber() {
		return poiNumber;
	}
	public void setPoiNumber(String poiNumber) {
		this.poiNumber = poiNumber;
	}
	public String getNationalityAr() {
		return nationalityAr;
	}
	public void setNationalityAr(String nationalityAr) {
		this.nationalityAr = nationalityAr;
	}
	public String getNationalityEn() {
		return nationalityEn;
	}
	public void setNationalityEn(String nationalityEn) {
		this.nationalityEn = nationalityEn;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusLocation() {
		return busLocation;
	}
	public void setBusLocation(String busLocation) {
		this.busLocation = busLocation;
	}
	public String getDriver1Number() {
		return driver1Number;
	}
	public void setDriver1Number(String driver1Number) {
		this.driver1Number = driver1Number;
	}
	public String getDriver1Name() {
		return driver1Name;
	}
	public void setDriver1Name(String driver1Name) {
		this.driver1Name = driver1Name;
	}
	public String getDriver1NationalityAr() {
		return driver1NationalityAr;
	}
	public void setDriver1NationalityAr(String driver1NationalityAr) {
		this.driver1NationalityAr = driver1NationalityAr;
	}
	public String getDriver1NationalityEn() {
		return driver1NationalityEn;
	}
	public void setDriver1NationalityEn(String driver1NationalityEn) {
		this.driver1NationalityEn = driver1NationalityEn;
	}
	public String getDriver2Number() {
		return driver2Number;
	}
	public void setDriver2Number(String driver2Number) {
		this.driver2Number = driver2Number;
	}
	public String getDriver2Name() {
		return driver2Name;
	}
	public void setDriver2Name(String driver2Name) {
		this.driver2Name = driver2Name;
	}
	public String getDriver2NationalityAr() {
		return driver2NationalityAr;
	}
	public void setDriver2NationalityAr(String driver2NationalityAr) {
		this.driver2NationalityAr = driver2NationalityAr;
	}
	public String getDriver2NationalityEn() {
		return driver2NationalityEn;
	}
	public void setDriver2NationalityEn(String driver2NationalityEn) {
		this.driver2NationalityEn = driver2NationalityEn;
	}
	public String getSdpAr() {
		return sdpAr;
	}
	public void setSdpAr(String sdpAr) {
		this.sdpAr = sdpAr;
	}
	public String getSdpEn() {
		return sdpEn;
	}
	public void setSdpEn(String sdpEn) {
		this.sdpEn = sdpEn;
	}
	public String getSdpTypeAr() {
		return sdpTypeAr;
	}
	public void setSdpTypeAr(String sdpTypeAr) {
		this.sdpTypeAr = sdpTypeAr;
	}
	public String getSdpTypeEn() {
		return sdpTypeEn;
	}
	public void setSdpTypeEn(String sdpTypeEn) {
		this.sdpTypeEn = sdpTypeEn;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedUserName() {
		return updatedUserName;
	}
	public void setUpdatedUserName(String updatedUserName) {
		this.updatedUserName = updatedUserName;
	}
	
	public String getPaidByUserNumber() {
		return paidByUserNumber;
	}
	public void setPaidByUserNumber(String paidByUserNumber) {
		this.paidByUserNumber = paidByUserNumber;
	}
	public String getPaidByUserName() {
		return paidByUserName;
	}
	public void setPaidByUserName(String paidByUserName) {
		this.paidByUserName = paidByUserName;
	}
}
