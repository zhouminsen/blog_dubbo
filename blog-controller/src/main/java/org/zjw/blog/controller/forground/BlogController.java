package org.zjw.blog.controller.forground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zjw.blog.controller.BaseController;
import org.zjw.blog.controller.WebUtil;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.service.BlogService;
import org.zjw.blog.vo.BlogLuceneVo;
import org.zjw.blog.vo.BlogVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/blog")
@Controller
public class BlogController extends BaseController {

	@Resource
	private BlogService blogService;

	/**
	 * 搜索博客
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/search")
	public String searchBlog(HttpServletRequest request) {
		Map<String, Object> queryMap = WebUtil.getParameterMap(request);
		try {
			Page<BlogLuceneVo> page = blogService.getPageBykeyword(queryMap);
			if (page.getResultData().isEmpty()) {
				// 如果没有找到数据提示信息
				request.setAttribute("dataEmptyMsg","找不到");
			}
			request.setAttribute("page", page);
			request.setAttribute("blogList", page.getResultData());
			request.setAttribute("keyword", queryMap.get("keyword"));
			request.setAttribute("displayPage", "/foreground/blog/result.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "foreground/main";
	}

	/**
	 * 查看博客详情信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(HttpServletRequest request,
			@PathVariable("id") Integer id) {
		//ModelAndView mav = new ModelAndView();
		BlogVo blogVo = blogService.getVoById(id);
		request.setAttribute("blog", blogVo);
		request.setAttribute("commentList", blogVo.getCommentList());
		request.setAttribute("displayPage", "/foreground/blog/view.jsp");
		//mav.setViewName("foreground/main");
		return "foreground/main";
	}

}