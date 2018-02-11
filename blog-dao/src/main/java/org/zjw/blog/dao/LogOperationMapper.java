package org.zjw.blog.dao;


import org.zjw.blog.entity.LogOperation;
import org.zjw.blog.vo.LogOperationVo;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface LogOperationMapper extends BaseDao<LogOperation>{
	/**
	 * 多条件查询vo
	 * @param queryMap
	 * @return
	 */
	List<LogOperationVo> selectVoByCondition(Map<String, Object> queryMap);
	
	/**
	 * 多条件查询vo记录数
	 * @param queryMap
	 * @return
	 */
	int selectVoCountByCondition(Map<String, Object> queryMap);
}