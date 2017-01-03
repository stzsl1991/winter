package com.shulin.winter.excel.impl;

import com.shulin.winter.excel.ExcelExportService;
import com.shulin.winter.exl.ExlOutUtil;
import com.shulin.winter.exl.ExlPageQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by shulin on 17/1/3.
 */
@Slf4j
@Service
public class ExcelExportServiceImpl<T> implements ExcelExportService<T> {

    @Autowired
    private ExlPageQuery<T> exlPageQuery;

    @Override
    public void exportLittleExcel(List beanList, Class exportBeanClz, OutputStream outputStream) throws IOException {
        long startTime = System.currentTimeMillis();
        SXSSFWorkbook wb = ExlOutUtil.initSXSSFWorkbook();
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        try {
            ExlOutUtil.exportExcel(sh, 0, beanList, exportBeanClz);
        } catch (Exception e) {
            throw new RuntimeException("Excel导出失败！");
        } finally {
            try {
                wb.write(outputStream);
                outputStream.flush();
            } catch (IOException e) {
                throw e;
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("Excel导出耗时：{}ms", (endTime - startTime));

    }

    @Override
    public void exportLargeExcel(Class exportBeanClz, Map params, int totalNum, OutputStream outputStream) throws Exception {
        long startTime = System.currentTimeMillis();
        SXSSFWorkbook wb = ExlOutUtil.initSXSSFWorkbook();
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        int offset = (int) params.get("offset");
        int limit = (int) params.get("limit");
        // 根据行数求数据提取次数
        int export_times = totalNum % limit > 0 ? totalNum / limit
                + 1 : totalNum / limit;
        //具体内容赋值
        int rowNum = 0;
        List<?> tList = null;
        for (int j = 0; j < export_times; j++) {
            tList = exlPageQuery.getBeansByPage(params);

            if (!CollectionUtils.isEmpty(tList)) {
                if (j != 0) {
                    rowNum = limit * j + 1;//自己的0行对应Execl的1行
                }
                ExlOutUtil.exportExcel(sh, rowNum, tList, exportBeanClz);
            }
            offset = offset + limit;
            params.put("offset", offset);
        }
        try {
            wb.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            throw e;
        }
        long endTime = System.currentTimeMillis();
        log.info("Excel导出耗时：{}ms", (endTime - startTime));
    }
}
