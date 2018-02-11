package org.zjw.blog.controller.forground;

import org.springframework.stereotype.Controller;
import org.zjw.blog.controller.BaseController;
import org.zjw.blog.service.BlogTypeService;

import javax.annotation.Resource;

@Controller
public class BlogTypeController extends BaseController {
	
	@Resource
	private BlogTypeService blogTypeService;
	
}