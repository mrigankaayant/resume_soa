package com.ayantsoft.resume.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.resume.dao.LocationDao;
import com.ayantsoft.resume.pojo.Location;

@Repository
public class LocationDaoImpl implements Serializable,LocationDao {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7833301001599358225L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Location> getLocation() {
		List<Location>locationList = new ArrayList<Location>();
		locationList = mongoTemplate.findAll(Location.class,"location");
		return locationList;
	}

}
