package org.zjw.blog.dao;


import org.zjw.blog.entity.Operation;

import java.util.List;

@MyBatisRepository
public interface OperationMapper extends BaseDao<Operation> {
	
	/**
	 * 根据菜单id获得操作权限
	 * @param menuId
	 * @return
	 */
	List<Operation> selectByMenuId(Integer menuId);
	
	/**
	 * 根据菜单id查询记录数
	 * @param menuId
	 * @return
	 */
	int selectCountByMenuId(Integer menuId);
	
}