package com.shulin.winter.exl;

import com.shulin.winter.annotions.EnumDataType;
import com.shulin.winter.annotions.ExlOutParseResult;
import com.shulin.winter.annotions.ExlOutParser;
import com.shulin.winter.common.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by shulin on 17/1/3.
 */
public class ExlOutUtil {


    /**
     * 内存中保留 1000 条数据，以免内存溢出，其余写入硬盘
     * @return
     */
    public static SXSSFWorkbook initSXSSFWorkbook(){
        return new SXSSFWorkbook(1000);
    }

    /**
     * 导出工具类
     *
     * @param sh            Excel中的表
     * @param rowNum        从哪一行开始写入数据，rowNum==0表示输出列名，分页使用
     * @param beanList      导出对象集合
     * @param exportBeanClz 导出对象Clazz
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void exportExcel(Sheet sh, int rowNum, List<?> beanList, Class exportBeanClz) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, IOException {

        List<ExlOutParseResult> exlOutParseResultList = null;
        try {
            exlOutParseResultList = ExlOutParser.parseExlOut(exportBeanClz);
        } catch (Exception e) {
            throw new RuntimeException("Excel导出对象注解解析失败！");
        }
        if (CollectionUtils.isEmpty(exlOutParseResultList)) {
            throw new RuntimeException("没有需要导出的列！");
        }
        if (rowNum == 0) {
            //创建Excel的标题
            int size = exlOutParseResultList.size();
            Row row = sh.createRow(0);   // 创建第一行对象
            for (int i = 0; i < size; i++) {
                row.createCell(exlOutParseResultList.get(i).getColSeq()).setCellValue(exlOutParseResultList.get(i).getColName());
            }
        }
        //具体内容赋值
        if (rowNum < 1) {
            rowNum = 1;
        }
        int autoSeq = rowNum - 1;
        if (!CollectionUtils.isEmpty(beanList)) {
            if (beanList.size() > 5000) {
                throw new RuntimeException("导出数据大小一次不能超过5000行！");
            }
            for (Object bean : beanList) {
                Row tmp = sh.createRow(rowNum);
                for (ExlOutParseResult exlOutParseResult : exlOutParseResultList) {
                    Cell cell = tmp.createCell(exlOutParseResult.getColSeq());
                    String result = null;
                    if (exlOutParseResult.getAutoIncrement()) {
                        result = String.valueOf(autoSeq);
                        autoSeq++;
                    } else {
                        Field field = null;
                        try {
                            field = bean.getClass().getDeclaredField(exlOutParseResult.getFieldName());
                        } catch (NoSuchFieldException e) {
                            throw new NoSuchFieldException();
                        }
                        field.setAccessible(true);
                        Object val = null;
                        try {
                            val = field.get(bean);
                        } catch (IllegalAccessException e) {
                            throw new IllegalAccessException();
                        }
                        //解析日期格式
                        if (exlOutParseResult.getFieldType().equals(Date.class)) {
                            result = DateUtil.convertDateToStr((Date) val, exlOutParseResult.getFormatStr());
                        }
                        //解析枚举
                        else if (!StringUtils.isEmpty(exlOutParseResult.getEnumName())) {
                            String enumName = exlOutParseResult.getEnumName();
                            Class<?> cls = null;
                            try {
                                cls = Class.forName(enumName);
                            } catch (ClassNotFoundException e) {
                                throw e;
                            }
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
                        }
                        //其他类型直接转成String输出
                        else {
                            result = String.valueOf(val);
                        }
                    }
                    cell.setCellValue(result);
                }
                rowNum++;
            }
        }
    }
}
