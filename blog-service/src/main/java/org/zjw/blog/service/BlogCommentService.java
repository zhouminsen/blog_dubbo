
package org.zjw.blog.service;


import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.BlogComment;
import org.zjw.blog.vo.BlogCommentVo;

import java.util.Map;

public interface BlogCommentService {

	 /**
	 * 发表评论
	 * @param comment
	 * @return
	 * @throws Exception 
	 */
	int save(BlogComment comment) throws Exception ;
	
	/**
	 * 查询评论分页对象BlogCommentVo
	 * @param queryMap
	 * @return
	 */
	Page<BlogCommentVo> getPageVoByCondition(Map<String, Object> queryMap);

	/**
	 * 批删除评论
	 * @param idArray
	 * @param userId
	 * @return
	 */
	int deleteLogicBatch(String[] idArray, Integer userId);
	
	/**
	 * 评论审核
	 * @param state 0:默认 1:通过 2:不通过
	 * @param idArray 
	 * @return
	 */
	int review(Integer state, String[] idArray);
}
