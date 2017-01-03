package winter;//package com.shulin.winter;
//
//import com.shulin.winter.annotions.ExlOutParseResult;
//import com.shulin.winter.annotions.ExlOutParser;
//import com.shulin.winter.common.BdUtil;
//import com.shulin.winter.common.JSONUtil;
//import com.shulin.winter.dao.order.OrderInfoDao;
//import com.shulin.winter.entity.order.OrderInfo;
//import com.shulin.winter.utils.ExlExportService;
//import com.shulin.winter.utils.POIUtils;
//import com.shulin.winter.example.OrderInfoVo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by shulin on 16/12/25.
// */
//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = {"classpath:excel-context.xml"})
//@Slf4j
//public class ExcelTest {
//
//    @Autowired
//    private POIUtils poiUtils;
//
//    @Autowired
//    private ExlExportService<OrderInfoVo> exlExportService;
//
//    @Autowired
//    private OrderInfoDao orderInfoDao;
//
//
//    @Test
//    public void createWorkBookTest() throws Exception {
//        poiUtils.createWorkBook();
//    }
//
//    @Test
//    public void readWorkBookTest() {
//
//    }
//
//
//    @Test
//    public void annotionsTest() throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        params.put("shopId", 48L);
//        List<OrderInfo> orderInfoList = orderInfoDao.select(params);
////        将数据库数据转换为有@ExlOut注解的对象
//        List<OrderInfoVo> orderInfoVos = BdUtil.bo2do4List(orderInfoList, OrderInfoVo.class);
////        log.info("orderInfoVos={}", JSONUtil.object2Json(orderInfoVos));
//        //解析annotion
//        List<ExlOutParseResult> exlOutParseResultList = ExlOutParser.parseExlOut(OrderInfoVo.class);
//
//        Collections.sort(exlOutParseResultList);
//        log.info("exlOutParseResultList={}", JSONUtil.object2Json(exlOutParseResultList));
//        OutputStream out = new FileOutputStream("/Users/shulin/excel/xxx.xls");
//        //导出数据
//        exlExportService.exportLittleExcel(orderInfoVos, OrderInfoVo.class, out);
//    }
//
//    @Test
//    public void exportLargeExcelTest() throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        params.put("offset", 0);
//        params.put("limit", 1000);
//        OutputStream out = new FileOutputStream("/Users/shulin/excel/xxx.xls");
//        exlExportService.exportLargeExcel(OrderInfoVo.class, params, 7000, out);
//    }
//
//
//}
