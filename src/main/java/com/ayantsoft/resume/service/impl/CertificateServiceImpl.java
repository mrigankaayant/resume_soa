package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.CertificateDao;
import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.SkillCertificate;
import com.ayantsoft.resume.service.CertificateService;

@Service
public class CertificateServiceImpl implements Serializable,CertificateService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7808805983913152355L;
	
	@Autowired
	private CertificateDao certificateDao;

	@Override
	public List<Certificate> getCertificates(String[] profileSkills) {
		return certificateDao.getCertificate(profileSkills);
	}

	@Override
	public List<SkillCertificate> getCertificatesDetails() {
		return certificateDao.getCertificateDetails();
	}

	

}
