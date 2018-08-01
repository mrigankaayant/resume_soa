package com.ayantsoft.resume.create;

import com.ayantsoft.resume.pojo.Certificate;
import com.ayantsoft.resume.pojo.Environment;
import com.ayantsoft.resume.pojo.Project;
import com.ayantsoft.resume.pojo.Reponsibility;
import com.ayantsoft.resume.pojo.ResumeDetails;
import com.ayantsoft.resume.pojo.Summary;
import com.ayantsoft.resume.pojo.SkillFilter;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;


public class Template1 implements Resume {
	
	private ResumeDetails resumeDetails;
	
	public Template1(ResumeDetails resumeDetails){
		this.resumeDetails = resumeDetails;
	}
	
	@Override
	public String createResume() throws Exception {
		
	 String cTAbstractNumBulletXML = 
				"<w:abstractNum xmlns:w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' w:abstractNumId='0'>"
						+ "<w:multiLevelType w:val='hybridMultilevel'/>"
						+ "<w:lvl w:ilvl='0'><w:start w:val='1'/><w:numFmt w:val='bullet'/><w:lvlText w:val=''/><w:lvlJc w:val='left'/><w:pPr><w:ind w:left='720' w:hanging='360'/></w:pPr><w:rPr><w:rFonts w:ascii='Symbol' w:hAnsi='Symbol' w:hint='default'/></w:rPr></w:lvl>"
						+ "<w:lvl w:ilvl='1' w:tentative='1'><w:start w:val='1'/><w:numFmt w:val='bullet'/><w:lvlText w:val='o'/><w:lvlJc w:val='left'/><w:pPr><w:ind w:left='1440' w:hanging='360'/></w:pPr><w:rPr><w:rFonts w:ascii='Courier New' w:hAnsi='Courier New' w:cs='Courier New' w:hint='default'/></w:rPr></w:lvl>"
						+ "<w:lvl w:ilvl='2' w:tentative='1'><w:start w:val='1'/><w:numFmt w:val='bullet'/><w:lvlText w:val=''/><w:lvlJc w:val='left'/><w:pPr><w:ind w:left='2160' w:hanging='360'/></w:pPr><w:rPr><w:rFonts w:ascii='Wingdings' w:hAnsi='Wingdings' w:hint='default'/></w:rPr></w:lvl>"
						+ "</w:abstractNum>";
	 
	 
	 XWPFDocument document = new XWPFDocument();
	 CTNumbering cTNumbering = CTNumbering.Factory.parse(cTAbstractNumBulletXML);
	 CTAbstractNum cTAbstractNum = cTNumbering.getAbstractNumArray(0);
	 XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);
	 XWPFNumbering numbering = document.createNumbering();
	 BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);
	 BigInteger numID = numbering.addNum(abstractNumID);
	 
	 String resumeNameFileName = resumeDetails.getCandidateName()+"_"+resumeDetails.getResumeDetailsId();
	 String path = "/home/mriganka/projects/angular_workspace/resume_CLIENT/src/app/asset/resume/"+resumeNameFileName+".docx";
	 String databasePath = "../app/asset/resume/"+resumeNameFileName+".docx";
	 
	 File f = new File(path);
	 if(f.exists()) { 
		 f.delete();  
	 }else{
		 f.createNewFile();
	 }
	 
	 FileOutputStream out = new FileOutputStream(new File(path));
	 XWPFParagraph paragraph = document.createParagraph();
	 paragraph.setAlignment(ParagraphAlignment.CENTER);
	 XWPFRun nameRun = paragraph.createRun();
	 nameRun.setBold(true);
	 nameRun.setFontSize(14);
	 nameRun.setFontFamily("Calibri");
	 nameRun.setUnderline(UnderlinePatterns.SINGLE);
	 nameRun.setText(resumeDetails.getCandidateName());
	 nameRun.addBreak();
	 
	 XWPFParagraph roleParagraph = document.createParagraph();
	 roleParagraph.setAlignment(ParagraphAlignment.CENTER);
	 roleParagraph.setSpacingAfter(5);
	 XWPFRun roleRun = paragraph.createRun();
	 roleRun.setBold(true);
	 roleRun.setFontSize(14);
	 roleRun.setFontFamily("Calibri");
	 roleRun.setUnderline(UnderlinePatterns.SINGLE);
	 roleRun.setText(resumeDetails.getCandidateRole());
	 
	 // OBJECTIVE
	 
	 if(resumeDetails.getObjective() !=null){
	    XWPFParagraph obj = document.createParagraph();
		obj.setAlignment(ParagraphAlignment.LEFT);
		obj.setBorderBottom(Borders.THICK);
		obj.setSpacingAfter(5);
		XWPFRun objectiveRun = obj.createRun();
		objectiveRun.setBold(true);
		objectiveRun.setFontSize(11);
		objectiveRun.setFontFamily("Calibri");
		objectiveRun.setText("OBJECTIVE : ");
		
		XWPFParagraph objParagraph = document.createParagraph();
		objParagraph.setSpacingAfter(5);
		XWPFRun objRun = objParagraph.createRun();
		objRun.setText(resumeDetails.getObjective());
		objRun.addBreak();
		}
	 
	 // PROFILE SUMMARY
	 
	 if(resumeDetails.getProfileSummary() != null && resumeDetails.getProfileSummary().size() >0){
			XWPFParagraph summaryParagraph = document.createParagraph();
			summaryParagraph.setAlignment(ParagraphAlignment.LEFT);
			summaryParagraph.setBorderBottom(Borders.THICK);
			summaryParagraph.setSpacingAfter(5);
			XWPFRun summaryRun = summaryParagraph.createRun();
			summaryRun.setBold(true);
			summaryRun.setFontSize(11);
			summaryRun.setFontFamily("Calibri");
			summaryRun.setText("PROFILE SUMMARY");

			for(Summary s:resumeDetails.getProfileSummary()){
				if(s.getType().equals("skill")){
					XWPFParagraph summaryListParagraph = document.createParagraph();
					summaryListParagraph.setSpacingAfter(5);
					summaryListParagraph.setNumID(numID);
					XWPFRun summaryListRun = summaryListParagraph.createRun();
					summaryListRun.setText(s.getSummaryName());
				}
			}
			
			for(Summary s:resumeDetails.getProfileSummary()){
				if(s.getType().equals("common")){
					XWPFParagraph summaryListParagraph = document.createParagraph();
					summaryListParagraph.setSpacingAfter(5);
					summaryListParagraph.setNumID(numID);
					XWPFRun summaryListRun = summaryListParagraph.createRun();
					summaryListRun.setText(s.getSummaryName());
				}
			}
	 }
	 
	 XWPFParagraph spaceAfterSummary = document.createParagraph();
	 spaceAfterSummary.setSpacingAfter(5);
	 
	 // TECHNICAL SKILL
	 
	 if(resumeDetails.getSkillFilterList() != null && resumeDetails.getSkillFilterList().size() >0){
			XWPFParagraph technicalSkillParagraph = document.createParagraph();
			technicalSkillParagraph.setSpacingAfter(5);
			technicalSkillParagraph.setAlignment(ParagraphAlignment.LEFT);
			technicalSkillParagraph.setBorderBottom(Borders.THICK);
			XWPFRun techSkillRun = technicalSkillParagraph.createRun();
			techSkillRun.setBold(true);
			techSkillRun.setFontSize(11);
			techSkillRun.setFontFamily("Calibri");
			techSkillRun.setText("TECHNICAL SKILLS : ");
			
			for(SkillFilter s:resumeDetails.getSkillFilterList()){
				XWPFParagraph skillListParagraph = document.createParagraph();
				skillListParagraph.setSpacingAfter(5);
				skillListParagraph.setNumID(numID);

				XWPFRun skillListRun1 = skillListParagraph.createRun();
				skillListRun1.setBold(true);
				skillListRun1.setText(s.getSkillType()+" : ");

				XWPFRun skillListRun2 = skillListParagraph.createRun();
				skillListRun2.setText(s.getSkills());
			}
		}
	 
	   XWPFParagraph spaceAfterSkill = document.createParagraph();
	   spaceAfterSkill.setSpacingAfter(5);
	  
	   //CERTIFICATE
	   
	   List<Certificate> certificateList = resumeDetails.getCertificateList();
	   List<String> externalCertificateList = resumeDetails.getExternalCertificates();
	   
	   if(certificateList != null){
		     if(externalCertificateList != null){
		    	  for(String c:externalCertificateList){
		    		  Certificate ce = new Certificate();
		    		  ce.setCertificateName(c);
		    		  certificateList.add(ce);
		    	  }
		     }
	   }else{
		   certificateList = new ArrayList<Certificate>();
		   if(externalCertificateList != null){
			   for(String c:externalCertificateList){
		    		  Certificate ce = new Certificate();
		    		  ce.setCertificateName(c);
		    		  certificateList.add(ce);
		    	  }
		   }
	   }
	   
	   if(certificateList.size() > 0){
			XWPFParagraph certificateParagraph = document.createParagraph();
			certificateParagraph.setAlignment(ParagraphAlignment.LEFT);
			certificateParagraph.setBorderBottom(Borders.THICK);
			certificateParagraph.setSpacingAfter(5);
			XWPFRun certificateRun = certificateParagraph.createRun();
			certificateRun.setBold(true);
			certificateRun.setFontSize(11);
			certificateRun.setFontFamily("Calibri");
			certificateRun.setText("CERTIFICATION");

			for(Certificate c:resumeDetails.getCertificateList()){
				XWPFParagraph certificateListParagraph = document.createParagraph();
				certificateListParagraph.setSpacingAfter(5);
				certificateListParagraph.setNumID(numID);
				XWPFRun certificateListRun = certificateListParagraph.createRun();
				certificateListRun.setText(c.getCertificateName());
			}
		}
		
		XWPFParagraph spaceAfterCertifcate = document.createParagraph();
		spaceAfterCertifcate.setSpacingAfter(5);
		
		// PROFESSIONAL EXPREENCE
		
		if(resumeDetails.getProjectList() != null && resumeDetails.getProjectList().size() >0){
			XWPFParagraph expreenceParagraph = document.createParagraph();
			expreenceParagraph.setSpacingAfter(5);
			expreenceParagraph.setAlignment(ParagraphAlignment.LEFT);
			expreenceParagraph.setBorderBottom(Borders.THICK);
			XWPFRun expreenceRun = expreenceParagraph.createRun();
			expreenceRun.setBold(true);
			expreenceRun.setFontSize(11);
			expreenceRun.setFontFamily("Calibri");
			expreenceRun.setText("PROFESSIONAL EXPERIENCE : ");
			
			for(Project p:resumeDetails.getProjectList()){
				if(p.getCompanyName() != null && p.getLocation() != null){
					XWPFParagraph clientNameParagraph = document.createParagraph();
					clientNameParagraph.setSpacingAfter(1);
					XWPFRun r2 = clientNameParagraph.createRun();
					r2.setFontFamily("Calibri");
					r2.setBold(true);
					r2.setFontSize(12);
					r2.setText(p.getCompanyName()+","+p.getLocation());
				}
				
				if(p.getStartDate() != null && p.getEndDate() != null){
					XWPFParagraph durationParagraph = document.createParagraph();
					durationParagraph.setSpacingAfter(1);
					XWPFRun r2 = durationParagraph.createRun();
					r2.setFontFamily("Calibri");
					r2.setBold(true);
					r2.setFontSize(12);
					r2.setText(p.getStartDate()+" TO "+p.getEndDate());
				}
				
				if(p.getProjectRole() != null ){
					XWPFParagraph roleParagraphe = document.createParagraph();
					roleParagraphe.setSpacingAfter(20);
					XWPFRun r2 = roleParagraphe.createRun();
					r2.setFontFamily("Calibri");
					r2.setBold(true);
					r2.setFontSize(12);
					r2.setText(p.getProjectRole());
				}
				
				XWPFParagraph spaceAfterRole = document.createParagraph();
				spaceAfterRole.setSpacingAfter(5);
				
				if(p.getProjectDescription() != null){
					XWPFParagraph projectDescriptionParagraph = document.createParagraph();
					projectDescriptionParagraph.setSpacingBefore(5);
					projectDescriptionParagraph.setSpacingAfter(5);
					XWPFRun r1 = projectDescriptionParagraph.createRun();
					XWPFRun r2 = projectDescriptionParagraph.createRun();
					r1.setFontSize(12);
					r1.setBold(true);
					r1.setFontFamily("Calibri");
					r1.setText("Project Description : ");
					r2.setFontSize(11);
					r2.setText(p.getProjectDescription());
				}
				
				if(p.getProjectResponsibilities() != null && p.getProjectResponsibilities().size() >0){
					XWPFParagraph responsibilityParagraph = document.createParagraph();
					XWPFRun r1 = responsibilityParagraph.createRun();
					responsibilityParagraph.setSpacingAfter(5);
					r1.setFontSize(12);
					r1.setBold(true);
					r1.setFontFamily("Calibri");
					r1.setText("Responsibilities : ");
					
					for(Reponsibility r:p.getProjectResponsibilities()){
						XWPFParagraph responsibilityListParagraph = document.createParagraph();
						responsibilityListParagraph.setSpacingAfter(5);
						responsibilityListParagraph.setNumID(numID);
						XWPFRun responsibilityListRun = responsibilityListParagraph.createRun();
						responsibilityListRun.setText(r.getResponsibilityName());
					}
				}
				
				if(p.getEnvironment() != null && p.getEnvironment().size() >0){
					XWPFParagraph environmentParagraph = document.createParagraph();
					environmentParagraph.setSpacingAfter(5);
					XWPFRun r1 = environmentParagraph.createRun();
					XWPFRun r2 = environmentParagraph.createRun();
					r1.setFontSize(12);
					r1.setBold(true);
					r1.setFontFamily("Calibri");
					r1.setText("Environment : ");
					r2.setFontSize(11);
					String environmentList = null;
					for(Environment e:p.getEnvironment()){
						if(environmentList == null){
							environmentList = e.getEnvironmentName();
						}else{
							environmentList = environmentList + ","+e.getEnvironmentName();
						}
					}
					r2.setText(environmentList);
				}
				
				XWPFParagraph spaceAfterProject = document.createParagraph();
				spaceAfterProject.setSpacingAfter(50);
			}
		}
		
		XWPFParagraph spaceAfterProject = document.createParagraph();
		spaceAfterProject.setSpacingAfter(5);
		
		// EDUCATION 
		
		if(resumeDetails.getEducationList() != null && resumeDetails.getEducationList().size() >0){
			XWPFParagraph educationParagraph = document.createParagraph();
			educationParagraph.setSpacingAfter(5);
			educationParagraph.setAlignment(ParagraphAlignment.LEFT);
			educationParagraph.setBorderBottom(Borders.THICK);
			XWPFRun educationRun = educationParagraph.createRun();
			educationRun.setBold(true);
			educationRun.setFontSize(11);
			educationRun.setFontFamily("Calibri");
			educationRun.setText("EDUCATION : ");


			for(String edu : resumeDetails.getEducationList()){
				XWPFParagraph educationListParagraph = document.createParagraph();
				educationListParagraph.setSpacingAfter(5);
				educationListParagraph.setNumID(numID);
				XWPFRun educationListRun = educationListParagraph.createRun();
				educationListRun.setText(edu);
			}
		}
		document.write(out);
		out.close();
		return databasePath;
	}

}

