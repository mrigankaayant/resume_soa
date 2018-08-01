package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class Environment implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 900683419810104402L;
	
	private String environmentName;

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
}
