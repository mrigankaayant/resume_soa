package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

public class MandatorySummary implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5834810595750530257L;
	
	private String skillName;
	private List<Summary> summaries;
	
    public List<Summary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
}
