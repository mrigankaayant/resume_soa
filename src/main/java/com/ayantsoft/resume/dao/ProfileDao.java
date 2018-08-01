package com.ayantsoft.resume.dao;

import java.util.List;

import com.ayantsoft.resume.pojo.CarrierOverview;

public interface ProfileDao {
	
	List<CarrierOverview> getObjectiveList();
	List<String> getRoles(String[] skills);
	List<String> getAllRoles();

}
