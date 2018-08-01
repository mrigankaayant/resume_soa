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
import com.ayantsoft.resume.pojo.Project;
import com.ayantsoft.resume.pojo.ProjectDto;
import com.ayantsoft.resume.pojo.Reponsibility;
import com.ayantsoft.resume.service.ProjectService;
@RestController
public class ProjectController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2445988752888861922L;
	 
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public ResponseEntity<?> getProjectDetails(@RequestBody ProjectDto projectDto){
		
		if(projectDto.getLocation() != null){
			for(String s:projectDto.getLocation()){
				System.out.println(s);
			}
		}
		System.out.println("========================");
		
		if(projectDto.getDomain() != null){
			for(String s:projectDto.getDomain()){
				System.out.println(s);
			}
		}
		System.out.println("========================");
		
		if(projectDto.getProfile() != null){
			for(String s:projectDto.getProfile()){
				System.out.println(s);
			}
		}
		System.out.println("========================");
		
		
		List<Project> projectDetails = null;
		HttpStatus httpStatus = null;
		try{	
			projectDetails = projectService.getProjectDetails(projectDto.getLocation(),projectDto.getDomain(),projectDto.getProfile());
			
			if(projectDetails == null || projectDetails.isEmpty() ){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Project>>(projectDetails, httpStatus);
	}
}
