package org.zjw.blog.service.impl;


import org.springframework.stereotype.Service;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.core.util.page.PageUtil;
import org.zjw.blog.dao.LinkMapper;
import org.zjw.blog.entity.Link;
import org.zjw.blog.service.LinkService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkMapper linkMapper;

	public List<Link> getAll() {
		return linkMapper.selectAll();
	}

	public Page<Link> getPage(Map<String, Object> queryMap) {
		PageUtil.isEmptySetValue(queryMap);
		Page<Link> page = new Page<Link>((Integer) queryMap.get("currentPage"),
				(Integer) queryMap.get("rows"));
		queryMap.put("start", page.getStart());
		List<Link> linkList=linkMapper.selectByCondition(queryMap);
		page.setResultData(linkList);
		int totalCount=linkMapper.selectCountByCondition(queryMap);
		page.setTotalCount(totalCount);
		return page;
	}

	public int deleteLogic(String[] arrayId) {
		Integer[] ids=new Integer[arrayId.length];
		for (int i = 0; i < ids.length; i++) {
			ids[i]=Integer.parseInt(arrayId[i]);
		}
		return linkMapper.deleteLogicBatch(ids);
	}

	public int save(Link link) {
		return linkMapper.insert(link);
	}

	public int modify(Link link) {
		return linkMapper.updateByPrimaryKeySelective(link);
	}
	
	
}
