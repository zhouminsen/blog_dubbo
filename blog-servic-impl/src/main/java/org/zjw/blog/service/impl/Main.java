package org.zjw.blog.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zhoum on 2018/2/6.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        app.start();
        System.in.read();
    }
}
