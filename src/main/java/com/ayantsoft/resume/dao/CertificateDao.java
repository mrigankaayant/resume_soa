package com.ayantsoft.resume.dao;

import java.util.List;

import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.SkillCertificate;

public interface CertificateDao {
	List<Certificate> getCertificate(String[] profileSkills);
	List<SkillCertificate> getCertificateDetails();
}
