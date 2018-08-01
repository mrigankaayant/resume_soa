package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class Location implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -587946425017378411L;
	
	
	private String locationName;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
