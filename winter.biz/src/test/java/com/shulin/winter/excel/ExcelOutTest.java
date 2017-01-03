package com.shulin.winter.excel;

import com.shulin.winter.common.BdUtil;
import com.shulin.winter.dao.order.OrderInfoDao;
import com.shulin.winter.entity.order.OrderInfo;
import com.shulin.winter.example.OrderInfoVo;
import com.shulin.winter.exl.impl.ExlExportUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shulin on 16/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:biz-context.xml"})
@Slf4j
public class ExcelOutTest {
    @Autowired
    private OrderInfoDao orderInfoDao;

    @Test
    public void excelExportTest() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("shopId", 56L);
        List<OrderInfo> orderInfoList = orderInfoDao.select(params);
        log.info("size={}", orderInfoList.size());
        List<OrderInfoVo> orderInfoVos = BdUtil.bo2do4List(orderInfoList, OrderInfoVo.class);
        OutputStream outputStream = new FileOutputStream("/Users/shulin/excel/test.xls");
        ExlExportUtil.exportLittleExcel(orderInfoVos, OrderInfoVo.class, outputStream);
    }

    @Test
    public void excelExportTest2() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("shopId", 1L);
        params.put("offset", 0);
        params.put("limit", 30);

        OutputStream outputStream = new FileOutputStream("/Users/shulin/excel/test2.xls");
        ExlExportUtil.exportLargeExcel(OrderInfoVo.class, params, 300, outputStream);

    }


}
