import beans.StudentBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhoum on 2018/5/15.
 */
public class BeansTest extends BaseTest {

    @Autowired
    private StudentBean studentBean;

    @Test
    public void test() {
        System.out.println("spring容器启动了");
        System.out.println(studentBean);
    }
}
