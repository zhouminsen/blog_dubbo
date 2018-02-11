package org.zjw.blog.service.impl;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.stereotype.Service;
import org.zjw.blog.core.UserConstant;
import org.zjw.blog.core.permission.AddHeaderInterceptor;
import org.zjw.blog.core.permission.service.UploadImageService;
import org.zjw.blog.core.permission.service.UploadImageServiceImplService;
import org.zjw.blog.dao.BloggerMapper;
import org.zjw.blog.dao.FileRecordMapper;
import org.zjw.blog.entity.Blogger;
import org.zjw.blog.entity.FileRecord;
import org.zjw.blog.service.BloggerService;
import org.zjw.blog.vo.AuthUser;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerMapper bloggerMapper;

    @Resource
    private FileRecordMapper fileRecordMapper;

    public Blogger getById(Integer id) {
        return bloggerMapper.selectByPrimaryKey(id);
    }

    public int modifyPassword(String newPassword, Blogger blogger) {
        //md5加盐 加密
        newPassword = "";
        blogger.setPassword(newPassword);
        return bloggerMapper.updateByPrimaryKeySelective(blogger);
    }

    public int modify(Blogger blogger, Integer isChangePic) {
        int line = bloggerMapper.updateByPrimaryKeySelective(blogger);
        if (isChangePic == 1) {
            FileRecord f = new FileRecord();
            f.setFileName(blogger.getSubImageName());
            f.setFileAllUrl(UserConstant.USER_IMAGE_ADDR + "/" + blogger.getUsername() + "/" + blogger.getSubImageName());
            f.setFileDir(UserConstant.USER_IMAGE_PATH + "/" + blogger.getUsername());
            f.setCreateDate(new Date());
            f.setCreateUserId(blogger.getId());
            line = fileRecordMapper.insertSelective(f);
        }
        return line;
    }

    public String getUploadImgAuth(AuthUser authUser) {
        UploadImageServiceImplService service = new UploadImageServiceImplService();
        UploadImageService uploadImageService = service.getUploadImageServiceImplPort();
        Client client = ClientProxy.getClient(uploadImageService);
        client.getOutInterceptors().add(new AddHeaderInterceptor(authUser.getId().toString())); // 添加自定义拦截器
        client.getInInterceptors().add(new LoggingInInterceptor()); // 添加In拦截器 日志拦截器
        client.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加Out拦截器 日志拦截器
        String str = uploadImageService.getUploadAuth(0);
        return str;
    }

    @Override
    public List<Blogger> selectByCondition(Map<String, Object> queryMap) {
        return bloggerMapper.selectByCondition(queryMap);
    }
}
