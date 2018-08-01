package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class Summary implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7430485080517896768L;
	
	private String summaryName;
	private String type;

	public String getSummaryName() {
		return summaryName;
	}

	public void setSummaryName(String summaryName) {
		this.summaryName = summaryName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
