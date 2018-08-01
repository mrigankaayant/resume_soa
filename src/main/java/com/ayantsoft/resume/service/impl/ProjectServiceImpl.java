package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.ProjectDao;
import com.ayantsoft.resume.pojo.Project;
import com.ayantsoft.resume.service.ProjectService;
@Service
public class ProjectServiceImpl implements Serializable,ProjectService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6694024875674050769L;

	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Project> getProjectDetails(String[] locations, String[] domainNames, String[] profileSkill) {
		return projectDao.getProjectDetails(locations, domainNames, profileSkill);
	}

}
