import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.zjw.blog.core.util.UtilFuns;
import org.zjw.blog.entity.Blogger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringTest {
	/**
	 * 测试josnUtil
	 */
	@Test
	public void josnUtil() {
		String jsonString = "{\"a\":1,\"c\":\"b\"}";
		Map<Object, Object> map = JSON.parseObject(jsonString, Map.class);
		for (Entry<Object, Object> item : map.entrySet()) {
			System.out.println(item.getKey() + "----" + item.getValue());
		}
		System.out.println("map转换成转换成json格式的字符串");
		System.out.println(JSON.toJSON(map));

		System.out.println("对象转换成josn格式的字符串");
		Blogger blogger= new Blogger();
		blogger.setNickName("周家伟");
		blogger.setPassword("12345");
		blogger.equals("哈哈");
		blogger.setId(1);
		String tbString = JSON.toJSONString(blogger);
		System.out.println(tbString);

		System.out.println("json格式字符串转换成对象");
		blogger = JSON.parseObject(tbString,Blogger.class);
		System.out.println(blogger);
	}
	
	@Test
	public void josnUtil2() {
//		String param="a=b&c=d";
//		JSONObject jsonObject=JSONObject.fromObject(param);
//		System.out.println(jsonObject);
	}
	

	@Test
	public void booleanAndOr(){
		System.out.println(System.getProperty("user.dir")+"src/main/webapp/file/log");
	}
	
	@Test
	public void test() {
		List<String> aa=Arrays.asList("bb","cc","dd");
		System.out.println(UtilFuns.joinStr(aa, ","));
	}
	
	@Test
	public void test2() {
		StringBuilder sb=new StringBuilder("");
		System.out.println(sb.substring(1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
