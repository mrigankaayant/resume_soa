package com.ayantsoft.resume.dao;

import java.util.List;

import com.ayantsoft.resume.pojo.ResumeDetails;

public interface ResumeDetailsDao {
	
	public void save(ResumeDetails resumeDetails);
	public ResumeDetails getResumeDetails(String resumeDetailsId);
	public void updateResumeDetails(ResumeDetails resumeDetails);
	public List<ResumeDetails> list();
	public void removeResumeDetails(String resumeDetailsId);
	public ResumeDetails getTemplateDetails(String resumeDetailsId);



}
