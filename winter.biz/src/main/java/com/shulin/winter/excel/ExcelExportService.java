package com.shulin.winter.excel;


import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by shulin on 17/1/3.
 */
public interface ExcelExportService<T> {

    /**
     * 导出少量数据，直接传入数据集合
     *
     * @param beanList      导出对象集合
     * @param exportBeanClz 导出对象Clazz
     * @param outputStream  输出流
     * @throws Exception
     */
    void exportLittleExcel(List<T> beanList, Class exportBeanClz, OutputStream outputStream) throws Exception;


    /**
     * 分页导出大量数据，需要单独实现ExlPageQuery<T>接口，实现分页方法
     *
     * @param exportBeanClz 导出对象clazz
     * @param params        分页查询参数，包含offset 和 limit
     * @param totalNum      导出总条数
     * @param outputStream  输出流
     * @throws Exception
     */
    void exportLargeExcel(Class exportBeanClz, Map<String, Object> params, int totalNum, OutputStream outputStream) throws Exception;
}
