package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class Certificate implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2143641415390687098L;
	
	
	private String certificateName;


	public String getCertificateName() {
		return certificateName;
	}


	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
}
