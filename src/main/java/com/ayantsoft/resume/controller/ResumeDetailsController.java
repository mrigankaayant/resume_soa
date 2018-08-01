package com.ayantsoft.resume.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.create.Resume;
import com.ayantsoft.resume.create.ResumeFactory;
import com.ayantsoft.resume.pojo.ResumeDetails;
import com.ayantsoft.resume.service.ResumeDetailsService;

@RestController
public class ResumeDetailsController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 5702484558833685280L;
	
	@Autowired
	private ResumeDetailsService resumeDetailsService;
	
	@RequestMapping(value = "/saveresume", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody ResumeDetails resumeDetails){
		
		HttpStatus httpStatus = null;
		try{	
			resumeDetailsService.save(resumeDetails);
		    httpStatus = HttpStatus.OK;
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ResumeDetails>(resumeDetails,httpStatus);
	}
	
	
	@RequestMapping(value = "/generateresume/{resumeDetailsId}/{templateType}", method = RequestMethod.GET)
	public ResponseEntity<?> createResume(@PathVariable String resumeDetailsId,@PathVariable String templateType){
		
		HttpStatus httpStatus = null;
		String filePath = null;
		ResumeDetails resumeDetails = null;
		try{
			resumeDetails = resumeDetailsService.getResumeDetailsById(resumeDetailsId);
			
			Resume resume = ResumeFactory.getResume(templateType,resumeDetails);
			filePath = resume.createResume();
			resumeDetails.setDownloadedUrl(filePath);
			resumeDetailsService.updateResumeDetails(resumeDetails);
			
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ResumeDetails>(resumeDetails,httpStatus);
	}	
	
	
	
	
	@RequestMapping(value = "/resumeDetailsList", method = RequestMethod.GET)
	public ResponseEntity<?> listResumeDetails(){
		HttpStatus httpStatus = null;
		List<ResumeDetails> list = null;
		try{
			list = resumeDetailsService.list();
			if(list == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<ResumeDetails>>(list,httpStatus);
	}
	
	
	

	@RequestMapping(value = "/removeresume/{resumeDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<?> removeResumeDetails(@PathVariable String resumeDetailsId){
		
		HttpStatus httpStatus = null;
		List<ResumeDetails> resumeDetailsList = null;
		try{
			 ResumeDetails resumeDetails = resumeDetailsService.getResumeDetailsById(resumeDetailsId);
			 
			 if(resumeDetails.getDownloadedUrl() != null){
				 String url = resumeDetails.getDownloadedUrl();
				 String rootDir = "/home/mriganka/projects/angular_workspace/resume_CLIENT/src";
				 
				 File file = new File(rootDir+url);
				 if(file.exists()){
					 file.delete();
				 }
			 }
			 resumeDetailsService.removeResumeDetails(resumeDetailsId);
			 resumeDetailsList = resumeDetailsService.list();
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<ResumeDetails>>(resumeDetailsList,httpStatus);
	}
	
	
	
	@RequestMapping(value = "/resume/{resumeDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<?> getTemplateDetails(@PathVariable String resumeDetailsId){
		
		HttpStatus httpStatus = null;
		ResumeDetails templateDetails = null;
		try{
			templateDetails = resumeDetailsService.getTemplateDetails(resumeDetailsId);
			if(templateDetails == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ResumeDetails>(templateDetails,httpStatus);
	}	
	
	
}
