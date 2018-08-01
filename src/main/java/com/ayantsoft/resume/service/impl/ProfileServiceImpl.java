package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.ProfileDao;
import com.ayantsoft.resume.pojo.CarrierOverview;
import com.ayantsoft.resume.service.ProfileService;

@Service
public class ProfileServiceImpl implements Serializable,ProfileService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7577124125625632186L;
	
	@Autowired
	private ProfileDao profileDao;

	

	@Override
	public List<String> getRoles(String[] skills) {
		return profileDao.getRoles(skills);
	}



	@Override
	public List<CarrierOverview> getObjectiveList() {
		return profileDao.getObjectiveList();
	}



	@Override
	public List<String> getAllRoles() {
		return profileDao.getAllRoles();
	}

}
