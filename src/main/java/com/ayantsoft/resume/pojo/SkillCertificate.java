package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

public class SkillCertificate implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -5855975988218784091L;
	
	
	private String skill;
	private List<Certificate> certificates;
	
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public List<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
}
