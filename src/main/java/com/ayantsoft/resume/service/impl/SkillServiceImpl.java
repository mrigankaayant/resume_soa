package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.SkillDao;
import com.ayantsoft.resume.pojo.Skill;
import com.ayantsoft.resume.pojo.Summary;
import com.ayantsoft.resume.service.SkillService;


@Service
public class SkillServiceImpl implements Serializable,SkillService {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7449546490385809331L;

	@Autowired
	private SkillDao skillDao;
	
	
	@Override
	public List<Skill> getSkills(String[] skills) {
		return skillDao.getSkillList(skills);
	}


	@Override
	public List<Summary> getSkillSummaryList(String[] skills) {
		return skillDao.getSkillSummaryList(skills);
	}


	@Override
	public List<Skill> getSubSkillDetails(String[] skills) {
		return skillDao.getSubSkillDetails(skills);
	}

}
