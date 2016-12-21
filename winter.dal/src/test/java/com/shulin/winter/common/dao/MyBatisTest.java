package com.shulin.winter.common.dao;

import com.shulin.winter.dao.manager.UserDao;
import com.shulin.winter.entity.manager.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by shulin on 16/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@Slf4j
public class MyBatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        User user = userDao.selectById(1L);
        log.info("hello");
    }

}
