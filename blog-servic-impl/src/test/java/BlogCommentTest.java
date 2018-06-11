import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.service.BlogCommentService;
import org.zjw.blog.vo.BlogCommentVo;

import java.util.HashMap;
import java.util.Map;

public class BlogCommentTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContextTest.xml");
	BlogCommentService blogCommentService=(BlogCommentService) app.getBean("blogCommentService");
	
	@Test
	public void getVoByCondition() {
		((ClassPathXmlApplicationContext)app).registerShutdownHook();
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("userId", 1);
		Page<BlogCommentVo> page=blogCommentService.getPageVoByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (BlogCommentVo item : page.getResultData()) {
			System.out.println(item);
		}
	}
}
