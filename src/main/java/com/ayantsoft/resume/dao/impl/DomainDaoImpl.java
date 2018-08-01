package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.DomainDao;
import com.ayantsoft.resume.pojo.Domain;

@Repository
public class DomainDaoImpl implements Serializable,DomainDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 5837049969287883263L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public List<Domain> getDomain() {
		List<Domain>domainList = new ArrayList<Domain>();
		domainList = mongoTemplate.findAll(Domain.class,"domain");	
		return domainList;
	}

}
