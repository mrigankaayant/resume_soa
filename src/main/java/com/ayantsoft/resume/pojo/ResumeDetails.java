package com.ayantsoft.resume.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resume_details")
public class ResumeDetails implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -5298977272655856751L;
	
	@Id
	private String id;
	private String resumeDetailsId;
	private String candidateName;
	private String candidateRole;
	private String objective;
	private List<Summary> profileSummary;
	private List<SkillFilter> skillFilterList;
	private List<Certificate> certificateList;
	private List<Project> projectList;
	private List<String> educationList;
	private String tagSummary;
	private List<String> profileSkill;
	private String downloadedUrl;
	
	//==
	private List<String> selectedRoles;
	private List<String> selectedSubSkills;
	private List<String> externalCertificates;
	
	
		
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateRole() {
		return candidateRole;
	}
	public void setCandidateRole(String candidateRole) {
		this.candidateRole = candidateRole;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public List<Summary> getProfileSummary() {
		return profileSummary;
	}
	public void setProfileSummary(List<Summary> profileSummary) {
		this.profileSummary = profileSummary;
	}
	public List<SkillFilter> getSkillFilterList() {
		return skillFilterList;
	}
	public void setSkillFilterList(List<SkillFilter> skillFilterList) {
		this.skillFilterList = skillFilterList;
	}
	public List<Certificate> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<Certificate> certificateList) {
		this.certificateList = certificateList;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public List<String> getEducationList() {
		return educationList;
	}
	public void setEducationList(List<String> educationList) {
		this.educationList = educationList;
	}
	public String getResumeDetailsId() {
		return resumeDetailsId;
	}
	public void setResumeDetailsId(String resumeDetailsId) {
		this.resumeDetailsId = resumeDetailsId;
	}
	public String getDownloadedUrl() {
		return downloadedUrl;
	}
	public void setDownloadedUrl(String downloadedUrl) {
		this.downloadedUrl = downloadedUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTagSummary() {
		return tagSummary;
	}
	public void setTagSummary(String tagSummary) {
		this.tagSummary = tagSummary;
	}
	public List<String> getProfileSkill() {
		return profileSkill;
	}
	public void setProfileSkill(List<String> profileSkill) {
		this.profileSkill = profileSkill;
	}
	public List<String> getSelectedRoles() {
		return selectedRoles;
	}
	public void setSelectedRoles(List<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	public List<String> getSelectedSubSkills() {
		return selectedSubSkills;
	}
	public void setSelectedSubSkills(List<String> selectedSubSkills) {
		this.selectedSubSkills = selectedSubSkills;
	}
	public List<String> getExternalCertificates() {
		return externalCertificates;
	}
	public void setExternalCertificates(List<String> externalCertificates) {
		this.externalCertificates = externalCertificates;
	}
	
}
