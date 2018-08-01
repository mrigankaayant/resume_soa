package com.ayantsoft.resume.dao;

import java.util.List;

import com.ayantsoft.resume.pojo.Project;

public interface ProjectDao {
	List<Project> getProjectDetails(String[] locations,String[] domainNames,String[] profileSkill);
}
