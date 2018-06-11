package beans;

/**
 * Created by zhoum on 2018/5/15.
 */
public class Zjw {

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


    public void myInit() {

        System.out.println("zjw我被初始化了");
    }

    public void myDestroy() {

        System.out.println("zjw我被销毁了");
    }

    public static int factory() {
        System.out.println("我是factory");
        return 1;
    }


}
