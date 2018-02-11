package org.zjw.blog.service.impl;


import org.springframework.stereotype.Service;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.core.util.page.PageUtil;
import org.zjw.blog.dao.BackupMapper;
import org.zjw.blog.entity.Backup;
import org.zjw.blog.service.BackupService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("backupService")
public class BackupServiceImpl implements BackupService {

	@Resource
	private BackupMapper backupMapper;

	public Page<Backup> getPageByCondition(Map<String, Object> queryMap) {
		PageUtil.isEmptySetValue(queryMap);
		Page<Backup> page=new Page<Backup>((Integer)queryMap.get("currentPage"), (Integer)queryMap.get("rows"));
		List<Backup> backupList=backupMapper.selectByCondition(queryMap);
		int totalCount=backupMapper.selectCountByCondition(queryMap);
		page.setResultData(backupList);
		page.setTotalCount(totalCount);
		return page;
	}
}
