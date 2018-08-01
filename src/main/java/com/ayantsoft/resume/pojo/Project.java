package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 4284596810932115363L;
	
	private String location;
	private String companyName;
	private String domain;
	private String projectDescription;
	private String profile;
	private List<Reponsibility> projectResponsibilities;
	private List<Environment> environment;
	private String startDate;
	private String endDate;
	private String projectRole;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public List<Reponsibility> getProjectResponsibilities() {
		return projectResponsibilities;
	}
	public void setProjectResponsibilities(List<Reponsibility> projectResponsibilities) {
		this.projectResponsibilities = projectResponsibilities;
	}
	public List<Environment> getEnvironment() {
		return environment;
	}
	public void setEnvironment(List<Environment> environment) {
		this.environment = environment;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
