package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.ProfileSkillDao;
import com.ayantsoft.resume.pojo.ProfileSkill;

@Repository
public class ProfileSkillDaoImpl implements Serializable,ProfileSkillDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1717291216067978410L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<ProfileSkill> getProfileSkillList() {
		List<ProfileSkill> profileSkills = null;
		try{
			profileSkills = mongoTemplate.findAll(ProfileSkill.class,"profile_skill");
		}catch(Exception e){
			e.printStackTrace();
		}
		return profileSkills;
	}

}
