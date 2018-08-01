package com.ayantsoft.resume.pojo;

import java.util.List;

public class SkillSummary {
	
	private String skillName;
	private List<Summary> summaries;
	
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public List<Summary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}
}
