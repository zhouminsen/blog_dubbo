package org.zjw.blog.service.impl;

import org.springframework.stereotype.Service;
import org.zjw.blog.dao.FileRecordMapper;
import org.zjw.blog.entity.FileRecord;
import org.zjw.blog.service.DownloadService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoum on 2017/1/22.
 */
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

    @Resource
    private FileRecordMapper fileRecordMapper;

    /**
     * 查看文件记录
     *
     * @param paramMap
     * @return
     */
    @Override
    public List<FileRecord> list(Map<String, Object> paramMap) {
        List<FileRecord> fileRecordList=fileRecordMapper.getFileRecordList(paramMap);
        return fileRecordList;
    }
}

