package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.pojo.ProfileSkill;
import com.ayantsoft.resume.service.ProfileSkillService;

@RestController
public class ProfileSkillController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1242350893174565311L;
	
	@Autowired
	private ProfileSkillService profileSkillService;
	
	@RequestMapping(value = "/profileSkills", method = RequestMethod.GET)
	public ResponseEntity<?> getProfileSkillList(){
		List<ProfileSkill> profileSkills = null;
		HttpStatus httpStatus = null;
		try{	
			profileSkills = profileSkillService.getProfileSkillList();
			if(profileSkills == null || profileSkills.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<ProfileSkill>>(profileSkills, httpStatus);
	}
	
	

}
