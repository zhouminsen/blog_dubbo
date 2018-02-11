package org.zjw.blog.controller;

import org.springframework.stereotype.Controller;
import org.zjw.blog.service.LogErrorService;

import javax.annotation.Resource;

@Controller
public class LogErrorController extends BaseController {
	
	@Resource
	private LogErrorService logErrorService;
	
}