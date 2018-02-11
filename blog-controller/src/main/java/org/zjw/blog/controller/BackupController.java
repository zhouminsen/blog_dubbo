package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Backup;
import org.zjw.blog.service.BackupService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin/backup")
@Controller
public class BackupController extends BaseController{
	
	@Resource
	private BackupService backupService;
	
	@RequestMapping(value="list",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(HttpServletRequest request) {
		Map<String, Object> queryMap= WebUtil.getParameterMap(request);
		Page<Backup> page=backupService.getPageByCondition(queryMap);
		Map<String, Object> dataMap=new HashMap<String, Object>();
		dataMap.put("total", page.getTotalCount());
		dataMap.put("rows", page.getResultData());
		return JSON.toJSONString(dataMap);
	}
	
}