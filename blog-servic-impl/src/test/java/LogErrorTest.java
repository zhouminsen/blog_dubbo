import org.junit.Test;
import org.zjw.blog.entity.LogError;
import org.zjw.blog.service.LogErrorService;

import javax.annotation.Resource;
import java.util.Date;

public class LogErrorTest extends BaseTest{
	@Resource
	private LogErrorService logErrorService;
	
	@Test
	public void save() {
		LogError logError=new LogError();
		logError.setClassName("dsdasd");
		logError.setCreateDate(new Date());
		logError.setIpAddress("dsds");
		int line=logErrorService.save(logError);
		System.out.println(line);
	}
	
}
