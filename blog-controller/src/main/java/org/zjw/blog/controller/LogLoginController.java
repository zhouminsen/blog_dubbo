package org.zjw.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zjw.blog.core.util.DateUtil;
import org.zjw.blog.core.util.file.DownloadUtil;
import org.zjw.blog.core.util.file.POIUitl;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.LogLogin;
import org.zjw.blog.service.LogLoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@RequestMapping("admin/log/login")
@Controller
public class LogLoginController extends BaseController {

    @Resource
    private LogLoginService logLoginService;


    @RequestMapping("index")
    public String index() {
        return "admin/log/logLogin";
    }

    @RequestMapping("list")
    public void list(HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        Page<LogLogin> page = logLoginService.getPageByCondition(queryMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", page.getResultData());
        jsonObject.put("total", page.getTotalCount());
        WebUtil.write(response, jsonObject);
    }

    @RequestMapping("delete")
    public void delete(String ids, HttpServletResponse response) {
        String[] idArray = ids.split(",");
        int line = logLoginService.deleteLogicBatch(idArray);
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
     * poi操作excel
     * 备份excel
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("backup")
    public void backup(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        logLoginService.backup(queryMap);
//        logLoginService.exportExcel(queryMap, response);
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
        String filePath = "E:/log/login/" + fileName + ".xls";
        File file = new File(filePath);
        DownloadUtil downloadUtil = new DownloadUtil();
        try {
            downloadUtil.prototypeDownload(file, fileName + ".xls", response.getOutputStream(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 后台日志下载
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping("exportData")
    public void downloadImage(HttpServletResponse response) throws Exception {
//设置总标题
        String brow = "登录日志";
        //每列的标题栏
        List<String> titleRow = Arrays.asList("登录名", "登录密码", "登录时间", "登录状态", "ip地址", "日志详情");
        List<List<String>> bodyRow = new ArrayList<>();
        List<LogLogin> logLoginList = logLoginService.getByCondition(new HashMap<>());
        for (LogLogin logLogin : logLoginList) {
            //设置每行的显示文字
            List<String> row = Arrays.asList(logLogin.getUsername(), logLogin.getPassword(),
                    DateUtil.dateToStr(logLogin.getCreateDate(), DateUtil.NORMALPATTERN),
                    logLogin.getStatus().toString(), logLogin.getIpAddress(), logLogin.getDescription());
            bodyRow.add(row);
        }
        POIUitl.createExcel(setRespone("aaa",response), brow, titleRow, bodyRow);
    }


    /**
     * 设置输出响应下载流
     *
     * @param fileName
     * @param response
     * @return
     * @throws IOException
     */
    private OutputStream setRespone(String fileName, HttpServletResponse response) throws IOException {
        //输出流
        OutputStream os = response.getOutputStream();
        //重置输出流
        response.reset();

        response.setContentType("application/vnd.ms-excel");
        //设置响应标题>这里浏览器会提示用户选择下载文件需要存放的路径>
        //后续生成的文件在输出流关闭后>action返回detailExcel进result指定响应内容为excel>自动写入该excel到该用户指定的路径中
        response.setHeader("Content-disposition", "attachment; fileName=" + new String((fileName + ".xlsx").getBytes(), "iso8859-1"));
        //response.setHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(brow,"utf-8")+".xls");(不可用)
        return os;
    }


}
