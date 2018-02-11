import org.junit.Test;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Role;
import org.zjw.blog.service.RoleService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class RoleTest extends BaseTest {
	@Resource
	private RoleService roleService;
	
	/**
	 * 多条查询分页对象
	 */
	@Test
	public void getPageVoByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<Role> page =roleService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (Role item : page.getResultData()) {
			System.out.println(item);
		}
	}
	
}
