package com.ayantsoft.resume.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.resume.pojo.Location;
import com.ayantsoft.resume.service.LocationService;

@RestController
public class LocationController implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3134957314666562603L;
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public ResponseEntity<?> getDomain(){
		List<Location> locationList = null;
		HttpStatus httpStatus = null;
		try{	
			locationList = locationService.getLocation();
			if(locationList == null || locationList.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Location>>(locationList, httpStatus);
	}
	

}
