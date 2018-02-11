import org.junit.Test;
import org.zjw.blog.core.UserConstant;
import org.zjw.blog.dao.FileRecordMapper;
import org.zjw.blog.entity.FileRecord;
import org.zjw.blog.service.DownloadService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoum on 2017/1/22.
 */
public class DownloadTest extends BaseTest {
    @Resource
    private DownloadService downloadService;

    @Resource
    private FileRecordMapper fileRecordMapper;

    @Test
    public void add() {
        String[] imageArr = {"20170120154059.jpg", "20170120163800.jpg", "20170120164423.jpg", "20170120172315.jpg", "20170120175007.gif"};
        for (int i = 0; i < imageArr.length; i++) {
            String s = imageArr[i];
            FileRecord f = new FileRecord();
            f.setCreateDate(new Date());
            f.setCreateUserId(1);
            f.setDeleteFlag(0);
            f.setFileDir(UserConstant.USER_IMAGE_PATH);
            f.setFileAllUrl(UserConstant.USER_IMAGE_ADDR+"/zjw/"+s);
            f.setFileName(s);
            fileRecordMapper.insertSelective(f);
        }
    }

    @Test
    public void list() {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        List<FileRecord> list = downloadService.list(queryMap);
        for (FileRecord fileRecord : list) {
            System.out.println(fileRecord);
        }
    }
}
