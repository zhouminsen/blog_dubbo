import org.junit.Test;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.LogLogin;
import org.zjw.blog.service.LogLoginService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class LogLoginTest extends BaseTest {
	@Resource
	private LogLoginService logLoginService;
	
	@Test
	public void getPageByCondition(){
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<LogLogin> page=logLoginService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (LogLogin item : page.getResultData()) {
			System.out.println(item);
		}
	}
	
	@Test
	public void delete() {
		System.out.println(logLoginService.deleteLogicBatch(new String[]{"54","55"}));
	}
}
