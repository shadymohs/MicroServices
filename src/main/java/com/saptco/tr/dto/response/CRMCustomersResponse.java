package com.saptco.tr.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.saptco.common.hbm.CRMContactsBean;

public class CRMCustomersResponse {

	private List<CRMContactsBean> customersList = new ArrayList<CRMContactsBean>();
	private String errorCode;
	private String errorDesc;
	
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
	public List<CRMContactsBean> getCustomersList() {
		return customersList;
	}
	public void setCustomersList(List<CRMContactsBean> customersList) {
		this.customersList = customersList;
	}
	
}
