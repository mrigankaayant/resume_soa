package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.resume.dao.ProjectDao;
import com.ayantsoft.resume.pojo.Project;
@Repository
public class ProjectDaoImpl implements Serializable,ProjectDao{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5778749729258670526L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Project> getProjectDetails(String[] locations, String[] domainNames, String[] profileSkill) {
		List<Project> projectList = new ArrayList<Project>();

		try{
			Criteria criteria = new Criteria();
			if((domainNames != null && domainNames.length >0) && (locations != null && locations.length >0)){
				Criteria c1 = Criteria.where("location").in(locations);
				Criteria c2 = Criteria.where("domain").in(domainNames);
				Criteria c3 = Criteria.where("profile").in(profileSkill);
				criteria.andOperator(c1,c2,c3);
			}else if(domainNames == null && (locations != null && locations.length >0)){
				Criteria c1 = Criteria.where("location").in(locations);
				Criteria c2 = Criteria.where("profile").in(profileSkill);
				criteria.andOperator(c1,c2);
			}else if(locations == null && (domainNames != null && domainNames.length >0)){
				Criteria c1 = Criteria.where("domain").in(domainNames);
				Criteria c2 = Criteria.where("profile").in(profileSkill);
				criteria.andOperator(c1,c2);
			}else{
				criteria.where("profile").in(profileSkill);
			}
			Query query = new Query(criteria);
			projectList = mongoTemplate.find(query,Project.class,"project");	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return projectList;
	}

}
