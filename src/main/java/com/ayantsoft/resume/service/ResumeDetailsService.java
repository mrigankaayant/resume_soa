package com.ayantsoft.resume.service;

import java.util.List;

import com.ayantsoft.resume.pojo.ResumeDetails;

public interface ResumeDetailsService {
	
	public void save(ResumeDetails resumeDetails);
	public ResumeDetails getResumeDetailsById(String resumeDetailsId);
	public void updateResumeDetails(ResumeDetails resumeDetails);
	public List<ResumeDetails> list();
	public void removeResumeDetails(String resumeDetailsId);
	public ResumeDetails getTemplateDetails(String resumeDetailsId);
}
