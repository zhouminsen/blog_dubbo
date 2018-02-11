package org.zjw.blog.dao;


import org.zjw.blog.entity.Role;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface RoleMapper extends BaseDao<Role> {
	/**
	 * 根据用户id查询
	 * @param queryMap
	 * @return
	 */
	List<Role> selectByUserId(Map<?, ?> queryMap);
}