package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.SkillDao;
import com.ayantsoft.resume.pojo.Skill;
import com.ayantsoft.resume.pojo.SkillSummary;
import com.ayantsoft.resume.pojo.Summary;

@Repository
public class SkillDaoImpl implements Serializable, SkillDao {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8099548132979916214L;
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Skill> getSkillList(String[] skills) {
		List<Skill> skillList = new ArrayList<Skill>();
		try{
			for(int i=0;i<skills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("profile").is(skills[i]));
				List<Skill> results = mongoTemplate.find(query, Skill.class, "skill");
				
				if(results != null && results.size()>0 ){
					skillList.addAll(results);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return skillList;
	}

	/*@Override
	public List<Summary> getSkillSummaryList(String[] skills) {
		List<Summary> skillSummaryList = new ArrayList<Summary>();
		try{
			for(int i=0;i<skills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("skillName").is(skills[i]));
				List<Skill> results = mongoTemplate.find(query, Skill.class, "skill");
				
				if(results != null && results.size()>0 ){
					for(Skill s : results){
						skillSummaryList.addAll(s.getSummaries());
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return skillSummaryList;
	}*/
	
	
	@Override
	public List<Summary> getSkillSummaryList(String[] skills) {
		List<Summary> skillSummaryList = new ArrayList<Summary>();
		try{
			for(int i=0;i<skills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("skillName").is(skills[i]));
				List<SkillSummary> results = mongoTemplate.find(query, SkillSummary.class, "skill_summary");
				
				if(results != null && results.size()>0 ){
					for(SkillSummary s : results){
						skillSummaryList.addAll(s.getSummaries());
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return skillSummaryList;
	}
	
	
	
	

	@Override
	public List<Skill> getSubSkillDetails(String[] skills) {
		List<Skill> skillList = new ArrayList<Skill>();
		try{
			for(int i=0;i<skills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("skillName").is(skills[i]));
				List<Skill> results = mongoTemplate.find(query, Skill.class, "skill");
				
				if(results != null && results.size()>0 ){
					skillList.addAll(results);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return skillList;
		
		
	}

}
