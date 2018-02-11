
package org.zjw.blog.service;


import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {
	
	/**
	 * 获得全部
	 * @return
	 */
	List<Link> getAll();
	
	/**
	 * 获得分页对象
	 * @return
	 */
	Page<Link> getPage(Map<String, Object> queryMap);
	
	/**
	 * 逻辑删除
	 * @param arrayId
	 * @return
	 */
	int deleteLogic(String[] arrayId);

	/**
	 * 添加
	 * @param link
	 * @return
	 */
	int save(Link link);
	
	/**
	 * 修改
	 * @param link
	 * @return
	 */
	int modify(Link link);

	
	
}
