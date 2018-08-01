package com.ayantsoft.resume.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.resume.dao.MandatorySummaryDao;
import com.ayantsoft.resume.pojo.Summary;
import com.ayantsoft.resume.service.MandatorySummaryService;

@Service
public class MandatorySummaryServiceImpl implements Serializable,MandatorySummaryService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7735739593166910246L;

	@Autowired
	private MandatorySummaryDao mandatorySummaryDao;
	
	
	@Override
	public List<Summary> getMandatorySummaryList() {
		return mandatorySummaryDao.getMandatorySummaryList();
	}

}
