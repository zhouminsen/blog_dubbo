import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Backup;
import org.zjw.blog.service.BackupService;

import java.util.HashMap;
import java.util.Map;

public class BackupTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	BackupService backupService=(BackupService) app.getBean("backupService");
	/**
	 * 多条件查询分页对象
	 */
	@Test
	public void getPageByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<Backup> page=backupService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (Backup item : page.getResultData()) {
			System.out.println(item);
		}
	}
}
