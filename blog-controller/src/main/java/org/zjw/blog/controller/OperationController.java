package org.zjw.blog.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Operation;
import org.zjw.blog.service.OperationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("admin/operation")
public class OperationController extends BaseController{
	
	@Resource
	private OperationService operationService;
	
	@RequestMapping("list")
	public void list(Integer menuId,HttpServletResponse response) {
		Page<Operation> page=operationService.getPageByMenuId(menuId);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", page.getResultData());
		jsonObject.put("total", page.getTotalCount());
		WebUtil.write(response, jsonObject);
	}
	
	@RequestMapping("modify")
	public void modify(Operation operation,HttpServletResponse response) {
		int line=operationService.modify(operation);
		JSONObject jsonObject=new JSONObject();
		if (line>=1) {
			jsonObject.put("success", true);
		}else {
			jsonObject.put("success", false);
			jsonObject.put("errorMsg", "修改数据失败");
		}
		WebUtil.write(response, jsonObject);
	}
	
	@RequestMapping("save")
	public void save(Operation operation,HttpServletResponse response) {
		operation.setCreateDate(new Date());
		int line=operationService.save(operation);
		JSONObject jsonObject=new JSONObject();
		if (line>=1) {
			jsonObject.put("success", true);
		}else {
			jsonObject.put("success", false);
			jsonObject.put("errorMsg", "添加数据失败");
		}
		WebUtil.write(response, jsonObject);
	}
	
	@RequestMapping("delete")
	public void delete(String ids,HttpServletResponse response) {
		String[] idArray=ids.split(",");
		int line=operationService.delete(idArray);
		JSONObject jsonObject=new JSONObject();
		if (line>=1) {
			jsonObject.put("success", true);
			jsonObject.put("delNums", idArray.length);
		}else {
			jsonObject.put("success", false);
			jsonObject.put("errorMsg", "删除数据失败");
		}
		WebUtil.write(response, jsonObject);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}