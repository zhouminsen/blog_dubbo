
package org.zjw.blog.service;


import org.zjw.blog.vo.LogOperationVo;

import java.io.IOException;
import java.util.Map;


public interface LogOperationService {

	/**
	 * 多条件查询分页对象
	 * @param queryMap
	 * @return
	 */
	org.zjw.blog.core.util.page.Page<LogOperationVo> getPageByCondition(Map<String, Object> queryMap);
	
	/**
	 * 备份excel
	 * @param queryMap
	 * @throws IOException 
	 * @throws Exception 
	 */
	void backup(Map<String, Object> queryMap) throws IOException, Exception;

	/**
	 * 逻辑批删除
	 * @param idArray
	 * @return
	 */
	int deleteLogicBatch(String[] idArray);
	
}
