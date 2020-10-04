package com.saptco.common.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CRMContactsBean {

	@Id
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "ID_TYPE_AR_DESC")
	private String idTypeAr;
	
	@Column(name = "ID_TYPE_EN_DESC")
	private String idTypeEn;
	
	@Column(name = "POI_NUMBER")
	private String poiNumber;
	
	@Column(name = "ID_VERSION")
	private String idVersion;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name = "NATIONALITY_AR_DESC")
	private String nationalityAr;
	
	@Column(name = "NATIONALITY_EN_DESC")
	private String nationalityEn;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getIdVersion() {
		return idVersion;
	}

	public void setIdVersion(String idVersion) {
		this.idVersion = idVersion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
