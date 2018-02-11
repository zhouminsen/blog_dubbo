package org.zjw.blog.controller.forground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zjw.blog.controller.BaseController;
import org.zjw.blog.controller.WebUtil;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Blog;
import org.zjw.blog.service.BlogService;
import org.zjw.blog.service.BlogTypeService;
import org.zjw.blog.service.BloggerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController extends BaseController {
	@Resource
	private BlogService blogService;

	@Resource
	private BlogTypeService blogTypeService;

	@Resource
	private BloggerService bloggerService;

	/**
	 * 加载首页
	 * 
	 * @param request
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		Map<String, Object> queryMap = WebUtil.getParameterMap(request);
		Page<Blog> page = blogService.getPageByCondition(queryMap);
		request.setAttribute("blogList", page.getResultData());
		request.setAttribute("page", page);
		request.setAttribute("displayPage", "/foreground/blog/list.jsp");
		return "foreground/main";
	}
	
	/**
	 * 加载下载页面
	 * @param request
	 * @return
	 */
	@RequestMapping("download")
	public String download(HttpServletRequest request) {
		request.setAttribute("displayPage", "/foreground/system/download.jsp");
		return "foreground/main";
	}

	@RequestMapping("testMap")
	public void testMap(HttpServletRequest request) {
		/*Map<String, Object> map = WebUtil.getParameterMap(request);
		for (Entry<String, Object> item : map.entrySet()) {
			System.out.println(item);
		}*/
	System.out.println(WebUtil.getIpAddr(request));
	}

}
