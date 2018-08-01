package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

public class Profile implements Serializable {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2313359417685359277L;
	
	private String profileName;
	private List<String> roles;
	
	
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
