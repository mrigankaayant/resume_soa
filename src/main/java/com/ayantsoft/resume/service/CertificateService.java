package com.ayantsoft.resume.service;

import java.util.List;

import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.SkillCertificate;

public interface CertificateService {
	List<Certificate> getCertificates(String[] profileSkills);
	List<SkillCertificate> getCertificatesDetails();

}
