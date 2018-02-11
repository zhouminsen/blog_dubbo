package org.zjw.blog.service.impl;

import org.springframework.stereotype.Service;
import org.zjw.blog.core.util.UtilFuns;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.core.util.page.PageUtil;
import org.zjw.blog.dao.BlogTypeMapper;
import org.zjw.blog.entity.BlogType;
import org.zjw.blog.service.BlogTypeService;
import org.zjw.blog.vo.BlogTypeVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeMapper blogTypeMapper;


	public List<BlogTypeVo> getBlogCountByType() {
		return blogTypeMapper.selectBlogCountByType();
	}


	public Page<BlogTypeVo> getPageVoByCondition(Map<String, Object> queryMap) {
		if (UtilFuns.isEmpty((String) queryMap.get("deleteFlag"))) {
			queryMap.put("deleteFlag", null);
		}else {
			queryMap.put("deleteFlag", Integer.parseInt((String) queryMap.get("deleteFlag")));
		}
		PageUtil.isEmptySetValue(queryMap);
		Page<BlogTypeVo> page=new Page<BlogTypeVo>((Integer)queryMap.get("currentPage"), (Integer)queryMap.get("rows"));
		queryMap.put("start", page.getStart());
		List<BlogTypeVo> blogTypeVoList=blogTypeMapper.selectVoByCondition(queryMap);
		page.setResultData(blogTypeVoList);
		int totalCount=blogTypeMapper.selectVoCountByCondition(queryMap);
		page.setTotalCount(totalCount);
		return page;
	}


	public int modify(BlogType blogType) {
		return blogTypeMapper.updateByPrimaryKeySelective(blogType);
	}


	public int save(BlogType blogType) {
		return blogTypeMapper.insertSelective(blogType);
	}


	public int deleteLogic(String[] idArray) {
		return blogTypeMapper.deleteLogicBatch(idArray);
	}

	
	
}
