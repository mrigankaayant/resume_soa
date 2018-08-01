package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.CommonDao;
import com.ayantsoft.resume.dao.ResumeDetailsDao;
import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.ResumeDetails;

@Repository
public class ResumeDetailsDaoImpl implements Serializable,ResumeDetailsDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -334947621618460642L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public void save(ResumeDetails resumeDetails) {
		try {
			if(resumeDetails.getResumeDetailsId() == null){
				resumeDetails.setResumeDetailsId(commonDao.getNextSequenceId("resume_details"));
			}else{
				mongoTemplate.save(resumeDetails,"resume_details");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!mongoTemplate.collectionExists(ResumeDetails.class)){
			mongoTemplate.createCollection(ResumeDetails.class);
		} 
		mongoTemplate.save(resumeDetails,"resume_details");
	}

	@Override
	public ResumeDetails getResumeDetails(String resumeDetailsId) {
		ResumeDetails resumeDetails = null;
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("resumeDetailsId").is(resumeDetailsId));
			resumeDetails = mongoTemplate.findOne(query,ResumeDetails.class,"resume_details");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resumeDetails;
	}

	@Override
	public void updateResumeDetails(ResumeDetails resumeDetails) {
		try{
			mongoTemplate.save(resumeDetails,"resume_details");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<ResumeDetails> list() {
		List<ResumeDetails> results = null;
		try{
			results = mongoTemplate.findAll(ResumeDetails.class,"resume_details");
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public void removeResumeDetails(String resumeDetailsId) {
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("resumeDetailsId").is(resumeDetailsId));
			mongoTemplate.remove(query, ResumeDetails.class, "resume_details");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ResumeDetails getTemplateDetails(String resumeDetailsId) {
		ResumeDetails templateDetails = null;
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("resumeDetailsId").is(resumeDetailsId));
			templateDetails = mongoTemplate.findOne(query,ResumeDetails.class,"resume_details");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return templateDetails;
	}

}
