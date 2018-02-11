package org.zjw.blog.controller.forground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zjw.blog.controller.BaseController;
import org.zjw.blog.entity.Blogger;
import org.zjw.blog.service.BloggerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/blogger")
public class BloggerController extends BaseController {
	
	@Resource
	private BloggerService bloggerService;
	
	@RequestMapping("/aboutMe")
	public String aboutMe(HttpServletRequest request,Integer id) {
		Blogger blogger=bloggerService.getById(1);
		request.setAttribute("blogger", blogger);
		request.setAttribute("displayPage", "/foreground/blogger/info.jsp");
		request.setAttribute("title", "关于博主");
		return "foreground/main";
	}
	
}