package org.zjw.blog.dao;


import org.zjw.blog.entity.BlogType;
import org.zjw.blog.vo.BlogTypeVo;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface BlogTypeMapper extends BaseDao<BlogType>{
    /**
     * 查询博客类型以及该类型下博客的数量 
     * @return
     */
	List<BlogTypeVo> selectBlogCountByType();
	
	/**
	 * 多条件查询VO
	 * @param queryMap
	 * @return
	 */
	List<BlogTypeVo> selectVoByCondition(Map<String, Object> queryMap);

	/**
	 * 多条件查询VO的记录数
	 * @param queryMap
	 * @return
	 */
	int selectVoCountByCondition(Map<String, Object> queryMap);

}