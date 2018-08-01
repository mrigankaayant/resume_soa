package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.resume.pojo.SubSkillDto;
import com.ayantsoft.resume.pojo.Summary;
import com.ayantsoft.resume.service.MandatorySummaryService;
import com.ayantsoft.resume.service.SkillService;

@RestController
public class ProfileSummeryController implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1800794063507653058L;
	
	
	@Autowired
	private MandatorySummaryService mandatorySummaryService;
	@Autowired
	private SkillService skillService ;
	
	@RequestMapping(value = "/profileSummery", method = RequestMethod.POST)
	public ResponseEntity<?> getProfileSummery(@RequestBody SubSkillDto subSkillDto){
		List<Summary> summaryList = new ArrayList<Summary>();
		HttpStatus httpStatus = null;
		try{	
			
			List<Summary> mandatorySummaryList =  mandatorySummaryService.getMandatorySummaryList();
			List<Summary> skillSummaryList = skillService.getSkillSummaryList(subSkillDto.getSubSkills());
			if(mandatorySummaryList != null && mandatorySummaryList.size() >0){
				summaryList.addAll(mandatorySummaryList);
			}
			if(skillSummaryList != null && skillSummaryList.size() >0){
				summaryList.addAll(skillSummaryList);
			}
			
			if(summaryList.size() == 0){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
			
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Summary>>(summaryList, httpStatus);
	}



}
