package com.ayantsoft.resume.create;

import com.ayantsoft.resume.pojo.ResumeDetails;

public class ResumeFactory {
	
	public static Resume getResume(String templateType,ResumeDetails resumeDetails){
		
		if("template1".equals(templateType)){
			 return new Template1(resumeDetails);
		}else if("template2".equals(templateType)){
			return new Template2(resumeDetails);
		}
		
		return null;
	}

}
