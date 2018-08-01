package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.pojo.Domain;
import com.ayantsoft.resume.service.DomainService;

@RestController
public class DomainController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8242024356518924973L;
	
	
	@Autowired
	private DomainService domainService;
	
	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public ResponseEntity<?> getDomain(){
		List<Domain> domainNameList = null;
		HttpStatus httpStatus = null;
		try{	
			domainNameList = domainService.getDomain();
			if(domainNameList == null || domainNameList.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Domain>>(domainNameList, httpStatus);
	}
}
