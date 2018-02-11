package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Link;
import org.zjw.blog.service.LinkService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/link")
public class LinkController extends BaseController {

	@Resource
	private LinkService linkService;

	@RequestMapping("index")
	public String index() {
		return "admin/blog/linkManage";
	}

	/**
	 * 拿大链接列表
	 * <br>设置 produces = "text/html;charset=UTF-8" 解决中文乱码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			Map<String, Object> queryMap = WebUtil.getParameterMap(request);
			Page<Link> page = linkService.getPage(queryMap);
			resultMap.put("rows", page.getResultData());
			resultMap.put("total", page.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("rows", "数据有误");
			resultMap.put("total", 0);
		}
		return JSON.toJSONString(resultMap);
	}

	@RequestMapping("save")
	public void save(Link link, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int line = linkService.save(link);
			resultMap.put("success", line >= 1 ? true : false);
		} catch (Exception e) {
			resultMap.put("success", false);
		}
		WebUtil.write(response, resultMap);
	}

	@RequestMapping("modify")
	public void modify(Link link, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int line = linkService.modify(link);
			if (line >= 1) {
				resultMap.put("success", true);
			} else {
				resultMap.put("success", false);
			}
		} catch (Exception e) {
			resultMap.put("success", false);
		}
		WebUtil.write(response, resultMap);
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(String ids) {
		String[] arrayId = ids.split(",");
		int line = linkService.deleteLogic(arrayId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", line>=1?true:false);
		return jsonObject.toString();
	}

}