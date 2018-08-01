package com.ayantsoft.resume.web.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ayantsoft.resume" })
public class WebMvcConfigure extends WebMvcConfigurerAdapter {
	

	public WebMvcConfigure() {
		
	}


	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		SimpleMongoDbFactory simpleMongoDbFactory = null;
		simpleMongoDbFactory =	new SimpleMongoDbFactory(new MongoClient("localhost",27017),"resume_details");
		
		/*MongoClientURI uri = new MongoClientURI("mongodb://ayantdev:AyantAstra422@ayant-shard-00-00-mn0tf.mongodb.net:27017,"
				+ "ayant-shard-00-01-mn0tf.mongodb.net:27017,"
				+ "ayant-shard-00-02-mn0tf.mongodb.net:27017/admin?replicaSet=ayant-shard-0&ssl=true");

		MongoClient mongoClient = new MongoClient(uri);
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "resume_details");*/
		
		return simpleMongoDbFactory;
	}


	
	@Bean
	public MongoTemplate mongoTemplate(){
		try {
			return new MongoTemplate(mongoDbFactory());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}

}

