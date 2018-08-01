package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class Domain implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6388383630292265744L;
	
	private String domainName;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
