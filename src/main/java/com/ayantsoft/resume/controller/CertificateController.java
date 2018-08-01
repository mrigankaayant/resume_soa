package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.ProfileSkillDto;
import com.ayantsoft.resume.pojo.SkillCertificate;
import com.ayantsoft.resume.service.CertificateService;

@RestController
public class CertificateController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2639398750523718616L;
	
	@Autowired
	private CertificateService certificateService;

	@RequestMapping(value = "/certificates", method = RequestMethod.POST)
	public ResponseEntity<?> getCertificates(@RequestBody ProfileSkillDto profileSkillDto){	
		List<Certificate> certificates = null;
		HttpStatus httpStatus = null;
		try{	
			certificates = certificateService.getCertificates(profileSkillDto.getProfileSkill());
			if(certificates == null || certificates.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Certificate>>(certificates, httpStatus);
	}

	@RequestMapping(value = "/certificatedetails", method = RequestMethod.GET)
	public ResponseEntity<?> getCertificates(){	
		List<SkillCertificate> certificatesList = null;
		HttpStatus httpStatus = null;
		try{	
			certificatesList = certificateService.getCertificatesDetails();
			if(certificatesList == null || certificatesList.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<SkillCertificate>>(certificatesList, httpStatus);
	}



}
