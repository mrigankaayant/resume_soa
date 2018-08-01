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

import com.ayantsoft.resume.pojo.CarrierOverview;
import com.ayantsoft.resume.pojo.ProfileSkillDto;
import com.ayantsoft.resume.service.ProfileService;


@RestController
public class ProfileController implements Serializable{

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 5807377249781142433L;


	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/objectives", method = RequestMethod.GET)
	public ResponseEntity<?> getObjectives(){
		List<CarrierOverview> objectives = null;
		HttpStatus httpStatus = null;
		try{	
			objectives = profileService.getObjectiveList();
			if(objectives == null || objectives.isEmpty() ){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<CarrierOverview>>(objectives, httpStatus);
	}


	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<?> getRoles(@RequestBody ProfileSkillDto profileSkillDto){
		List<String> roles = null;
		HttpStatus httpStatus = null;
		try{	
			roles = profileService.getRoles(profileSkillDto.getProfileSkill());
			if(roles == null || roles.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<String>>(roles, httpStatus);
	}
	
	
	@RequestMapping(value = "/allRoles", method = RequestMethod.GET)
	public ResponseEntity<?> getAllRoles(){
		List<String> roles = null;
		HttpStatus httpStatus = null;
		try{	
			roles = profileService.getAllRoles();
			if(roles == null || roles.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<String>>(roles, httpStatus);
	}





}
