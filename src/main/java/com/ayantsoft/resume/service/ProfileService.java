package com.ayantsoft.resume.service;

import java.util.List;

import com.ayantsoft.resume.pojo.CarrierOverview;

public interface ProfileService {
	
	List<CarrierOverview> getObjectiveList();
	List<String> getRoles(String[] skills);
	List<String> getAllRoles();
}
