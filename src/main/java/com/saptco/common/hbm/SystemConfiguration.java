package com.saptco.common.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_CONFIGURATION")
public class SystemConfiguration {
	
	@Id
	@Column(name="SYSTEM_CONFIGURATION_ID")
	private Long id;
	@Column(name="CODE")
	private String code;
	@Column(name="LOCALE_NAME")
	private String localeName;
	@Column(name="FOREIGN_NAME")
	private String foreignName;
	@Column(name="VALUE")
	private String value;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLocaleName() {
		return localeName;
	}
	public void setLocaleName(String localeName) {
		this.localeName = localeName;
	}
	public String getForeignName() {
		return foreignName;
	}
	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
