package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class ProjectDto implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3856618078408207184L;
	
	
	private String[] location;
	private String[] domain;
	private String[] profile;
	
	
	public String[] getProfile() {
		return profile;
	}
	public void setProfile(String[] profile) {
		this.profile = profile;
	}
	public String[] getLocation() {
		return location;
	}
	public void setLocation(String[] location) {
		this.location = location;
	}
	public String[] getDomain() {
		return domain;
	}
	public void setDomain(String[] domain) {
		this.domain = domain;
	}
}
