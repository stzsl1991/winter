package com.shulin.winter.springtest;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by shulin on 16/11/1.
 */
@Setter
@Getter
public class Person {
    private String name;
    private Integer age;

    public void show() {
        System.out.println("姓名：" + name + ";age：" + age);
    }
}
