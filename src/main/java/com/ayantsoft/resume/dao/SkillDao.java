package com.ayantsoft.resume.dao;

import java.util.List;

import com.ayantsoft.resume.pojo.Skill;
import com.ayantsoft.resume.pojo.Summary;

public interface SkillDao {
	List<Skill> getSkillList(String[] skills);
	List<Summary> getSkillSummaryList(String[] skills);
	List<Skill> getSubSkillDetails(String[] skills);
}
