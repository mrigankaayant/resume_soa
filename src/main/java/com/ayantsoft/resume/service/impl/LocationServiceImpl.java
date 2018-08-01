package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.LocationDao;
import com.ayantsoft.resume.pojo.Location;
import com.ayantsoft.resume.service.LocationService;
@Service
public class LocationServiceImpl implements Serializable,LocationService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6535194179954807507L;
	
	@Autowired
	private LocationDao locationDao;
	
	
	@Override
	public List<Location> getLocation() {
		return locationDao.getLocation();
	}

}
