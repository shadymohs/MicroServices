package com.saptco.tr.dto.response;

public class MobileSystemConfigDto{
	
	private Boolean allowSellerOTP = true;
	private Boolean displaySearchPopup = true;
	private Integer kioskLogOut = 2;
	
	public Boolean getAllowSellerOTP() {
		return allowSellerOTP;
	}
	public void setAllowSellerOTP(Boolean allowSellerOTP) {
		this.allowSellerOTP = allowSellerOTP;
	}
	public Boolean getDisplaySearchPopup() {
		return displaySearchPopup;
	}
	public void setDisplaySearchPopup(Boolean displaySearchPopup) {
		this.displaySearchPopup = displaySearchPopup;
	}
	public Integer getKioskLogOut() {
		return kioskLogOut;
	}
	public void setKioskLogOut(Integer kioskLogOut) {
		this.kioskLogOut = kioskLogOut;
	}
	
//	@Override
//	public String toString() {
//		return "MobileSystemConfigDto [allowSellerOTP=" + allowSellerOTP +
//				", displaySearchPopup=" + displaySearchPopup +
//				", kioskLogOut=" + kioskLogOut + "]";
//	}
	
}
