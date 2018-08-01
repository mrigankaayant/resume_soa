package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.UserMstDao;
import com.ayantsoft.resume.pojo.UserMst;


@Repository
public class UserMstDaoImpl implements Serializable,UserMstDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -7403281444497297208L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public UserMst getUserMstByUsername(String userName) {
		UserMst user = null;
		try{
			Criteria criteria = new Criteria();
			criteria.andOperator(Criteria.where("username").is(userName),Criteria.where("active").is(true));
			Query query = new Query(criteria);
			user = mongoTemplate.findOne(query,UserMst.class,"userMst");
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

}
