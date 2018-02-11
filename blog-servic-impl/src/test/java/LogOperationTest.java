import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.service.LogOperationService;
import org.zjw.blog.vo.LogOperationVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogOperationTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	LogOperationService logOperationService=(LogOperationService) app.getBean("logOperationService");
	
	/**
	 * 多条查询分页对象
	 */
	@Test
	public void getPageVoByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<LogOperationVo> page =logOperationService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (LogOperationVo item : page.getResultData()) {
			System.out.println(item);
		}
	}
	
	@Test
	public void deleteLogicBatch() {
		String[] ids={"389","388"};
		System.out.println(logOperationService.deleteLogicBatch(ids));
	}
	
	/**
	 * 备份excel
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Test
	public void backup() throws IOException, Exception {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		logOperationService.backup(queryMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
