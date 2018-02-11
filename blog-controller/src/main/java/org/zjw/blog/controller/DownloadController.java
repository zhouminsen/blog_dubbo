package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zjw.blog.entity.FileRecord;
import org.zjw.blog.service.DownloadService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 博客类型
 *
 * @author 周家伟
 * @date 2016-7-19
 */
@Controller
@RequestMapping("/admin/download")
public class DownloadController extends BaseController {

    @Resource
    private DownloadService downloadService;


    /**
     * 跳转到下载首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "admin/file/download";
    }

    /**
     * 加载文件下载类型列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(HttpServletRequest request) {
        PageHelper.startPage(1, 10);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        List<FileRecord> list = downloadService.list(queryMap);
        PageInfo<FileRecord> pageInfo = new PageInfo<FileRecord>(list);
        resultMap.put("rows", JSON.toJSONString(pageInfo.getList()));
        resultMap.put("total", pageInfo.getTotal());
        return resultMap.toString();
    }

}