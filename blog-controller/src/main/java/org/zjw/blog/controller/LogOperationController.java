package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zjw.blog.core.util.file.DownloadUtil;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.service.LogOperationService;
import org.zjw.blog.vo.LogOperationVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin/log/operation")
@Controller
public class LogOperationController {

    @Resource
    private LogOperationService LogOperationService;

    @RequestMapping("index")
    public String index() {
        return "admin/log/logOperation";
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public JSONObject list(HttpServletRequest request) {
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        Page<LogOperationVo> page = LogOperationService.getPageByCondition(queryMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", page.getResultData());
        jsonObject.put("total", page.getTotalCount());
        return jsonObject;
    }

    @RequestMapping("delete")
    public void delete(String ids, HttpServletResponse response) {
        String[] idArray = ids.split(",");
        int line = LogOperationService.deleteLogicBatch(idArray);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (line >= 1) {
            resultMap.put("success", true);
            resultMap.put("delNums", idArray.length);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorMsg", "删除数据失败");
        }
        WebUtil.write(response, JSON.toJSONString(resultMap));
    }

    /**
     * 下载log4j日志
     *
     * @param response
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("downloadLog")
    public void downloadLog(HttpServletResponse response) throws UnsupportedEncodingException {
        //日志文件路径
        try {
            File file = new File("");
            DownloadUtil downloadUtil = new DownloadUtil();
            downloadUtil.prototypeDownload(file, "log.log", response.getOutputStream(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * jxl操作excel
     * 备份excel
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("backup")
    public void backup(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        LogOperationService.backup(queryMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        WebUtil.write(response, jsonObject);
    }

    /**
     * 下载备份
     *
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("downloadBackup")
    public void downloadBackup(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        fileName = URLDecoder.decode(fileName, "utf-8");
        String filePath = "E:/log/operation/" + fileName + ".xls";
        File file = new File(filePath);
        DownloadUtil downloadUtil = new DownloadUtil();
        try {
            downloadUtil.prototypeDownload(file, fileName + ".xls", response.getOutputStream(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
