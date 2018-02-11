package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.BlogType;
import org.zjw.blog.service.BlogTypeService;
import org.zjw.blog.vo.BlogTypeVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客类型
 *
 * @author 周家伟
 * @date 2016-7-19
 */
@Controller
@RequestMapping("admin/blog/type")
public class AdminBlogTypeController extends BaseController {

    @Resource
    private BlogTypeService blogTypeService;

    /**
     * 跳转到博文类型首页
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "admin/blog/blogTypeManage";
    }

    /**
     * 加载博文类型列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        Page<BlogTypeVo> page = blogTypeService.getPageVoByCondition(queryMap);
        resultMap.put("rows", JSON.toJSONString(page.getResultData()));
        resultMap.put("total", page.getTotalCount());
        return resultMap.toString();
    }

    /**
     * 添加
     *
     * @param blogType
     * @param response
     */
    @RequestMapping("save")
    public void save(BlogType blogType, HttpServletResponse response) {
        blogType.setCreateDate(new Date());
        int line = blogTypeService.save(blogType);
        String jsonStr = "{'success':" + (line >= 1 ? true : false) + "}";
        WebUtil.write(response, jsonStr);
    }

    /**
     * 修改
     *
     * @param blogType
     * @return
     */
    @RequestMapping("modify")
    @ResponseBody
    public String modify(BlogType blogType) {
        int line = blogTypeService.modify(blogType);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", line >= 1 ? true : false);
        return resultMap.toString();
    }

    /**
     * 删除数据
     *
     * @param ids
     */
    @RequestMapping("delete")
    public void delete(String ids, HttpServletResponse response) {
        String[] idArray = ids.split(",");
        int line = blogTypeService.deleteLogic(idArray);
        WebUtil.write(response, line >= 1 ? true : false);
    }


}