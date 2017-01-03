package winter.exl.impl;

import com.shulin.winter.common.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import winter.annotions.EnumDataType;
import winter.annotions.ExlOutParseResult;
import winter.annotions.ExlOutParser;
import winter.exl.ExlExportService;
import winter.exl.ExlPageQuery;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shulin on 16/12/25.
 */
@Component
@Slf4j
public class ExlExportServiceImpl<T> implements ExlExportService<T> {

    @Autowired
    private ExlPageQuery<T> exlPageQuery;


    @Override
    public void exportLittleExcel(List<T> beanList,Class exportBeanClz,OutputStream outputStream) throws Exception {
        long startTime = System.currentTimeMillis();
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        Row row = sh.createRow(0);   // 创建第一行对象


        List<ExlOutParseResult> exlOutParseResultList = ExlOutParser.parseExlOut(exportBeanClz);
        if (CollectionUtils.isEmpty(exlOutParseResultList)) {
            throw new RuntimeException("没有需要导出的列！");
        }
        //创建Excel的标题
        int size = exlOutParseResultList.size();
        for (int i = 0; i < size; i++) {
            row.createCell(exlOutParseResultList.get(i).getColSeq()).setCellValue(exlOutParseResultList.get(i).getColName());
        }
        //具体内容赋值
        int rowNum = 1;
        int autoSeq = 0;
        if (!CollectionUtils.isEmpty(beanList)) {
            for (T bean : beanList) {
                Row tmp = sh.createRow(rowNum);
                for (ExlOutParseResult exlOutParseResult : exlOutParseResultList) {
                    Cell cell = tmp.createCell(exlOutParseResult.getColSeq());
                    String result = null;
                    if (exlOutParseResult.getAutoIncrement()) {
                        result = String.valueOf(autoSeq);
                        autoSeq++;
                    } else {
                        Field field = bean.getClass().getDeclaredField(exlOutParseResult.getFieldName());
                        field.setAccessible(true);
                        Object val = field.get(bean);
                        if (exlOutParseResult.getFieldType().equals(Date.class)) {
                            result = DateUtil.convertDateToStr((Date) val, exlOutParseResult.getFormatStr());
                        } else if (!StringUtils.isEmpty(exlOutParseResult.getEnumName())) {
                            String enumName = exlOutParseResult.getEnumName();
                            Class<?> cls = Class.forName(enumName);
                            if (cls.isEnum()) {
                                for (Enum enu : (Enum[]) cls.getEnumConstants()) {
                                    EnumDataType dataType = (EnumDataType) enu;
                                    String s = dataType.getEnumValue(val);
                                    if (s != null) {
                                        result = s;
                                        break;
                                    }
                                }
                            }
                        } else {
                            result = String.valueOf(val);
                        }
                    }
                    cell.setCellValue(result);
                }
                rowNum++;
            }
        }

        // 把上面创建的工作簿输出到文件中
        wb.write(outputStream);
        outputStream.flush();
        //关闭输出流
        outputStream.close();
        long endTime = System.currentTimeMillis();
        log.info("耗时：{}ms", (endTime - startTime));
    }


    @Override
    public void exportLargeExcel(Class exportBeanClz, Map<String, Object> params, int totalNum,OutputStream outputStream) throws Exception {
        long startTime = System.currentTimeMillis();
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        Row row = sh.createRow(0);   // 创建第一行对象
        List<ExlOutParseResult> exlOutParseResultList = ExlOutParser.parseExlOut(exportBeanClz);
        if (CollectionUtils.isEmpty(exlOutParseResultList)) {
            throw new RuntimeException("没有需要导出的列！");
        }
        //创建Excel的标题
        int size = exlOutParseResultList.size();
        for (int i = 0; i < size; i++) {
            row.createCell(exlOutParseResultList.get(i).getColSeq()).setCellValue(exlOutParseResultList.get(i).getColName());
        }

        int offset = (int) params.get("offset");
        int limit = (int) params.get("limit");
        // 根据行数求数据提取次数
        int export_times = totalNum % limit > 0 ? totalNum / limit
                + 1 : totalNum / limit;
        //具体内容赋值
        int rowNum = 1;
        int autoSeq = 0;
        for (int j = 0; j < export_times; j++) {
            List<T> tList = exlPageQuery.getBeansByPage(params);
            if (!CollectionUtils.isEmpty(tList)) {
                for (T bean : tList) {
                    Row tmp = sh.createRow(rowNum);
                    for (ExlOutParseResult exlOutParseResult : exlOutParseResultList) {
                        Cell cell = tmp.createCell(exlOutParseResult.getColSeq());
                        String result = null;
                        if (exlOutParseResult.getAutoIncrement()) {
                            result = String.valueOf(autoSeq);
                            autoSeq++;
                        } else {
                            Field field = bean.getClass().getDeclaredField(exlOutParseResult.getFieldName());
                            field.setAccessible(true);
                            Object val = field.get(bean);

                            if (exlOutParseResult.getFieldType().equals(Date.class)) {
                                result = DateUtil.convertDateToStr((Date) val, exlOutParseResult.getFormatStr());
                            } else if (!StringUtils.isEmpty(exlOutParseResult.getEnumName())) {
                                String enumName = exlOutParseResult.getEnumName();
                                Class<?> cls = Class.forName(enumName);
                                if (cls.isEnum()) {
                                    for (Enum enu : (Enum[]) cls.getEnumConstants()) {
                                        EnumDataType dataType = (EnumDataType) enu;
                                        String s = dataType.getEnumValue(val);
                                        if (s != null) {
                                            result = s;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                result = String.valueOf(val);
                            }
                        }
                        cell.setCellValue(result);
                    }
                    rowNum++;
                }
            }
            offset = offset + limit;
            params.put("offset", offset);
        }
        // 把上面创建的工作簿输出到文件中
        wb.write(outputStream);
        outputStream.flush();
        //关闭输出流
        outputStream.close();
        long endTime = System.currentTimeMillis();
        log.info("耗时：{}ms", (endTime - startTime));


    }


    /**
     * 获取getter方法
     *
     * @param fieldName
     * @return
     */
    private String getGetterMethod(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }


}
