package com.shulin.winter.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = applicationContext.getBean("person",Person.class);
        person.show();
        HashMap map = new HashMap();
    }
}