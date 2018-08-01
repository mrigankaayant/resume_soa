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

import com.ayantsoft.resume.dao.MandatorySummaryDao;
import com.ayantsoft.resume.pojo.MandatorySummary;
import com.ayantsoft.resume.pojo.Summary;

@Repository
public class MandatorySummaryDaoImpl implements Serializable,MandatorySummaryDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4853517074116546309L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Summary> getMandatorySummaryList() {
		List<Summary> mandatorySummaryList = new ArrayList<Summary>();
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("skillName").is("ALlSkill"));
			MandatorySummary mandatorySummary = mongoTemplate.findOne(query,MandatorySummary.class,"mandatory_summery");
 
			if(mandatorySummary != null){
				mandatorySummaryList = mandatorySummary.getSummaries();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mandatorySummaryList;
	}
}


