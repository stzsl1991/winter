package com.shulin.winter.common.springtest;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FirstTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = applicationContext.getBean("person", Person.class);
        person.show();
    }


    @Test
    public void testMockito() {
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("hello");
        Assert.assertEquals("预期返回结果：","hello", list.get(5));
    }
}