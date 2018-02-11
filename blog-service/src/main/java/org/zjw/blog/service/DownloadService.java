package org.zjw.blog.service;


import org.zjw.blog.entity.FileRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by zhoum on 2017/1/22.
 */
public interface DownloadService {
    /**
     * 查看文件记录
     * @param paramMap
     * @return
     */
    List<FileRecord> list(Map<String, Object> paramMap);
}
