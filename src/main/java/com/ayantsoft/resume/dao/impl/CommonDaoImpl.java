package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ayantsoft.resume.dao.CommonDao;
import com.ayantsoft.resume.pojo.Sequence;


@Repository
public class CommonDaoImpl implements CommonDao,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5991841374640418142L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String getNextSequenceId(String key) throws Exception {

		  Query query = new Query(Criteria.where("id").is(key));
		  Update update = new Update();
		  update.inc("seq", 1);

		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);

		  Sequence seqId = (Sequence) mongoTemplate.findAndModify(query, update, options, Sequence.class);
		  
		  if (seqId == null) {
			throw new Exception("Unable to get sequence id for key : " + key);
		  }

		 return Long.toString(seqId.getSeq());
		  
	}
}
