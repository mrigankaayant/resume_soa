package com.ayantsoft.resume.web.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcConfigureInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	
	public WebMvcConfigureInitializer(){
		
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfigure.class };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	 @Override
	    protected Filter[] getServletFilters() {
	    	Filter [] singleton = { new CORSFilter()};
	    	return singleton;
	    }
}
