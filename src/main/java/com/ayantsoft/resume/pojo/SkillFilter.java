package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class SkillFilter implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -711786668471440144L;
	
	
	private String skillType;
	private String skills;
	
	
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	

}
