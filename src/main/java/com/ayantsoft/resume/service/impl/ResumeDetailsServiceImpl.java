package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.ResumeDetailsDao;
import com.ayantsoft.resume.pojo.ResumeDetails;
import com.ayantsoft.resume.service.ResumeDetailsService;

@Service
public class ResumeDetailsServiceImpl implements Serializable,ResumeDetailsService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -4574280105255292481L;
	
	@Autowired
	private ResumeDetailsDao resumeDetailsDao;

	@Override
	public void save(ResumeDetails resumeDetails) {
		resumeDetailsDao.save(resumeDetails);
	}

	@Override
	public ResumeDetails getResumeDetailsById(String resumeDetailsId) {
		return resumeDetailsDao.getResumeDetails(resumeDetailsId);
	}

	@Override
	public void updateResumeDetails(ResumeDetails resumeDetails) {
		resumeDetailsDao.updateResumeDetails(resumeDetails);
	}

	@Override
	public List<ResumeDetails> list() {
		return resumeDetailsDao.list();
	}

	@Override
	public void removeResumeDetails(String resumeDetailsId) {
		 resumeDetailsDao.removeResumeDetails(resumeDetailsId);
		
	}

	@Override
	public ResumeDetails getTemplateDetails(String resumeDetailsId) {
		return resumeDetailsDao.getTemplateDetails(resumeDetailsId);
	}

}
