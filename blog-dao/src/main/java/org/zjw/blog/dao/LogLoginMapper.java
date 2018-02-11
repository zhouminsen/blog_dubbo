package org.zjw.blog.dao;


import org.zjw.blog.entity.LogLogin;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 周家伟
 * @date 2016-7-18
 * @description 登录日志Mapper
 */
@MyBatisRepository
public interface LogLoginMapper extends BaseDao<LogLogin> {
	/**
	 * 根据ip地址查询login日志
	 * 
	 * @param queryMap
	 * @return
	 */
	List<LogLogin> selectByIp(Map<String, Object> queryMap);

}