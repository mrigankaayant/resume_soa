package com.ayantsoft.resume.service;

import java.util.List;

import com.ayantsoft.resume.pojo.Skill;
import com.ayantsoft.resume.pojo.Summary;

public interface SkillService {
	List<Skill> getSkills(String[] skills);
	List<Summary> getSkillSummaryList(String[] skills);
	List<Skill> getSubSkillDetails(String[] skills);
}
