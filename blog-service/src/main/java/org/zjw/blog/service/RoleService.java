
package org.zjw.blog.service;


import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {
	/**
	 * 根据用户id查询
	 * @return
	 */
	List<Role> getByUserId(Map<String, Object> queryMap);
	
	/**
	 * 多条件查旭分页对象
	 * @param queryMap
	 * @return
	 */
	Page<Role> getPageByCondition(Map<String, Object> queryMap);

	/**
	 * 根据用户id获得权限
	 * @param userId
	 * @return
	 */
	Set<String> getPermissionsByUserId(Integer userId);
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	int save(Role role);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	int modify(Role role);
	
	/**
	 * 根据id获得
	 * @param id
	 * @return
	 */
	Role getById(Integer id);
	
	/**
	 * 修改角色菜单
	 * @param
	 * @return
	 */
	int modifyRoleMenu(String menuIds, Integer roleId);
	
	/**
	 * 逻辑批删除
	 * @param idArray
	 * @return
	 */
	int deleteLogicBatch(String[] idArray);

}
