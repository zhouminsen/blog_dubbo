package org.zjw.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseController {
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;

	@InitBinder
	// 此方法用于日期的转换，如果未加，当页面日期格式转换错误，将报400错误，实际是因为此方法
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	
	// 解析页码
	public int parsePageNo(Long pageNo) {
		int pageNo2 = pageNo == null ? 1 : pageNo.intValue();
		return pageNo2;
	}

	/**
	 * 
	 * @param request
	 * @param toSaveLocation
	 *            保存的路径
	 * @return 保存后的文件名
	 * @throws UnsupportedEncodingException
	 */
	public List<String> uploadImg(HttpServletRequest request,
			String toSaveLocation) throws UnsupportedEncodingException {

		List<String> imgs = new ArrayList<String>();
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		// 取得request中的所有文件名
		Iterator<String> iter = multiRequest.getFileNames();
		while (iter.hasNext()) {
			String successFileName = null;
			// 取得上传文件
			MultipartFile file = multiRequest.getFile(iter.next());
			if (file != null) {
				// 取得当前上传文件的文件名称
				String myFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (myFileName.trim() != "") {
					// 当前时间+文件后缀组成 将要写入字节流的图片名
					Date currTime = new Date();
					SimpleDateFormat formatter2 = new SimpleDateFormat(
							"yyyyMMddhhmmssS", Locale.US);
					String fileName = new String((formatter2.format(currTime))
							.getBytes("iso-8859-1"));

					String ext = myFileName.substring(myFileName
							.lastIndexOf("."));
					fileName = fileName + ext;
					// 定义上传路径
					String path = toSaveLocation + "/" + fileName;
					File localFile = new File(path);
					try {
						file.transferTo(localFile);
						successFileName = fileName;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			imgs.add(successFileName);
		}
		return imgs;
	}
	
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
