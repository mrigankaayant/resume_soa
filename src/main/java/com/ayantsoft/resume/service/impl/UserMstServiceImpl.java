package com.ayantsoft.resume.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.UserMstDao;
import com.ayantsoft.resume.pojo.UserMst;
import com.ayantsoft.resume.service.UserMstService;


@Service
public class UserMstServiceImpl implements Serializable,UserMstService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1029532987680264671L;
	
	@Autowired
	private UserMstDao userMstDao; 
	

	@Override
	public UserMst getUserMstByUsername(String userName) {
		return userMstDao.getUserMstByUsername(userName);
	}

}
