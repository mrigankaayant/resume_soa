package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.ProfileSkillDao;
import com.ayantsoft.resume.pojo.ProfileSkill;
import com.ayantsoft.resume.service.ProfileSkillService;

@Service
public class ProfileSkillServiceImpl implements Serializable,ProfileSkillService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7420898540008864537L;
	
	@Autowired
	private ProfileSkillDao profileSkillDao;

	@Override
	public List<ProfileSkill> getProfileSkillList() {
		return profileSkillDao.getProfileSkillList();
	}
	
	

}
