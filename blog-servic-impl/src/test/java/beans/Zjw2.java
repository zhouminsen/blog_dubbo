package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zhoum on 2018/5/15.
 */
public class Zjw2 implements InitializingBean, DisposableBean {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("zjw2我被初始化了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("zjw2我被销毁了");
    }



}
