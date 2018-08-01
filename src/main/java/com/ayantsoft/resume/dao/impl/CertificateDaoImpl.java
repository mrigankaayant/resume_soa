package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.CertificateDao;
import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.SkillCertificate;

@Repository
public class CertificateDaoImpl implements Serializable,CertificateDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4820789511300111877L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	

	@Override
	public List<Certificate> getCertificate(String[] profileSkills) {
		List<Certificate> certificatesList = new ArrayList<Certificate>();
		try{
			for(int i=0;i<profileSkills.length;i++){
				Query query = new Query();
				query.addCriteria(Criteria.where("skill").is(profileSkills[i]));
				SkillCertificate skillCertificate = mongoTemplate.findOne(query,SkillCertificate.class,"skill_certificate");
				List<Certificate> results = skillCertificate.getCertificates();
				if(results != null && results.size() >0){
					certificatesList.addAll(results);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return certificatesList;

	}



	@Override
	public List<SkillCertificate> getCertificateDetails() {
		List<SkillCertificate> certificatesList = null;
		try{
			certificatesList =mongoTemplate.findAll(SkillCertificate.class,"skill_certificate");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return certificatesList;
	}

}
