
package org.zjw.blog.service;


import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Operation;

import java.util.List;

public interface OperationService {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Operation getById(int id);
	
	/**
	 * 根据菜单id获得操作权限
	 * @param menuId
	 * @return
	 */
	List<Operation> getByMenuId(Integer menuId);
	
	/**
	 * 根据菜单id获得分页对象
	 * @param menuId
	 * @return
	 */
	Page<Operation> getPageByMenuId(Integer menuId);
	
	/**
	 * 修改操作
	 * @param operation
	 * @return
	 */
	int modify(Operation operation);

	/**
	 * 添加
	 * @param operation
	 * @return
	 */
	int save(Operation operation);
	
	/**
	 * 逻辑删除数据
	 * @param idArray
	 * @return
	 */
	int delete(String[] idArray);
	
}
