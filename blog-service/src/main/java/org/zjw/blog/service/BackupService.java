
package org.zjw.blog.service;


import org.zjw.blog.entity.Backup;

import java.util.Map;


public interface BackupService {
	
	/**
	 * 多条件查询分页对象
	 * @param queryMap
	 * @return
	 */
	org.zjw.blog.core.util.page.Page<Backup> getPageByCondition(Map<String, Object> queryMap);
	
}
