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

import com.ayantsoft.resume.dao.ProfileDao;
import com.ayantsoft.resume.pojo.CarrierOverview;
import com.ayantsoft.resume.pojo.Profile;


@Repository
public class ProfileDaoImpl implements Serializable,ProfileDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 3641754275761802828L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	

	@Override
	public List<String> getRoles(String[] skills) {
		List<String> roleList = new ArrayList<String>();
		try{
			for(int i=0;i<skills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("profileName").is(skills[i]));
				Profile profile = mongoTemplate.findOne(query,Profile.class,"profile");
				List<String> rols = profile.getRoles();
				if(rols != null && rols.size() >0){
				    roleList.addAll(rols);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return roleList;
	}



	@Override
	public List<CarrierOverview> getObjectiveList() {
		List<CarrierOverview> objectives = null;
		try{
			objectives = mongoTemplate.findAll(CarrierOverview.class,"carrier_Overview");
		}catch(Exception e){
			e.printStackTrace();
		}
		return objectives;
	}



	@Override
	public List<String> getAllRoles() {
		List<String> roles = new ArrayList<String>();
		try{
			List<Profile> profiles = mongoTemplate.findAll(Profile.class,"profile");
			for(Profile p:profiles){
				roles.addAll(p.getRoles());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return roles;
	}
	
	
	
	
	
	
	

}
