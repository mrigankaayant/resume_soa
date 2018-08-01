package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

public class Skill implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2233882241648477565L;
	
	private String profile;
	private String skillName;
	private String skillType;
	private List<Summary> summaries;
	
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public List<Summary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}
}
