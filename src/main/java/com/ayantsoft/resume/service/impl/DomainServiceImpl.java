package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.resume.dao.DomainDao;
import com.ayantsoft.resume.pojo.Domain;
import com.ayantsoft.resume.service.DomainService;

@Service
public class DomainServiceImpl implements Serializable,DomainService {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7193197694174173940L;
	@Autowired	
	private DomainDao domainDao;

	@Override
	public List<Domain> getDomain() {
		return domainDao.getDomain();
	}

}
