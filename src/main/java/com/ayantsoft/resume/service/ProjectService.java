package com.ayantsoft.resume.service;

import java.util.List;

import com.ayantsoft.resume.pojo.Project;

public interface ProjectService {
	List<Project> getProjectDetails(String[] locations,String[] domainNames,String[] profileSkill);

}
