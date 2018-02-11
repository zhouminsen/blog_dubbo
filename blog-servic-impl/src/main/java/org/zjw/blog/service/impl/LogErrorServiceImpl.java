package org.zjw.blog.service.impl;


import org.springframework.stereotype.Service;
import org.zjw.blog.dao.LogErrorMapper;
import org.zjw.blog.entity.LogError;
import org.zjw.blog.service.LogErrorService;

import javax.annotation.Resource;

@Service("logErrorService")
public class LogErrorServiceImpl implements LogErrorService {

	@Resource
	private LogErrorMapper logErrorMapper;
	
	
	public int save(LogError logError) {
		return logErrorMapper.insertSelective(logError);
	}

}
