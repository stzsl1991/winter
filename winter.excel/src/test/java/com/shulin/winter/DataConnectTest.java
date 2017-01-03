//package com.shulin.winter;
//
//import com.shulin.winter.common.JSONUtil;
//import com.shulin.winter.dao.order.OrderInfoDao;
//import com.shulin.winter.entity.order.OrderInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by shulin on 16/12/25.
// */
//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = {"classpath:excel-context.xml"})
//@Slf4j
//public class DataConnectTest {
//
//    @Autowired
//    private OrderInfoDao orderInfoDao;
//
//    @Test
//    public void test() {
//        OrderInfo orderInfo = orderInfoDao.selectById(178L);
//        log.info("orderInfo={}", JSONUtil.object2Json(orderInfo));
//    }
//
//}
