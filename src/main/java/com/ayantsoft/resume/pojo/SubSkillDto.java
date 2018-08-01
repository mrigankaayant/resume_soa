package com.ayantsoft.resume.pojo;

import java.io.Serializable;

public class SubSkillDto implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6846798922570934331L;
	
	private String[] subSkills;

	public String[] getSubSkills() {
		return subSkills;
	}

	public void setSubSkills(String[] subSkills) {
		this.subSkills = subSkills;
	}
}
