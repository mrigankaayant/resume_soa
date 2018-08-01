package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.pojo.ProfileSkillDto;
import com.ayantsoft.resume.pojo.Skill;
import com.ayantsoft.resume.pojo.SkillFilter;
import com.ayantsoft.resume.pojo.SubSkillDto;
import com.ayantsoft.resume.service.SkillService;

@RestController
public class SkillController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1723404948839580467L;
	
	@Autowired 
	private SkillService skillService;
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ResponseEntity<?> getSkills(@RequestBody ProfileSkillDto profileSkillDto){
		List<Skill> skillList = null;
		HttpStatus httpStatus = null;
		try{	
			skillList = skillService.getSkills(profileSkillDto.getProfileSkill());
			if(skillList == null || skillList.isEmpty() ){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Skill>>(skillList, httpStatus);
	}
	
	
	
	@RequestMapping(value = "/techSkills", method = RequestMethod.POST)
	public ResponseEntity<?> getTechSkills(@RequestBody SubSkillDto subSkillDto){
		List<SkillFilter> techSkillList = new ArrayList<SkillFilter>();
		HttpStatus httpStatus = null;
		try{	
			List<Skill> skillList = skillService.getSubSkillDetails(subSkillDto.getSubSkills());
			
			Set<String> skillTypeList = new HashSet<String>();
			for(Skill s:skillList){
				skillTypeList.add(s.getSkillType());
			}
			
			if(skillTypeList != null && skillTypeList.size()>0){
				for(String type:skillTypeList){
					SkillFilter skillFilter = new SkillFilter();
					skillFilter.setSkillType(type);
					String sList = null;
					for(Skill s:skillList){
						if(s.getSkillType().equals(type)){
							if(sList == null){
								sList = s.getSkillName();
							}else{
								sList = sList + ","+s.getSkillName();
							}
						}
					}
					skillFilter.setSkills(sList);
					techSkillList.add(skillFilter);
				}
			}
			
			if(techSkillList.size() == 0){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<SkillFilter>>(techSkillList, httpStatus);
	}
	
	
	
}
