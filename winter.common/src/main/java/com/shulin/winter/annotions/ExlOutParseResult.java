package com.shulin.winter.annotions;

import lombok.Getter;
import lombok.Setter;

/**
 * 解析注解后的对象
 * Created by shulin on 16/12/25.
 */
@Setter
@Getter
public class ExlOutParseResult implements Comparable {
    private int colSeq;  //序列
    private String colName;  //列名
    private String fieldName;  //属性名称
    private Class fieldType;    //属性类型
    private String formatStr;   //日期格式
    private Boolean autoIncrement;  //是否自增，全局属性

    private String enumName;     //枚举名
    private String enumMethod;    //枚举方法

    @Override
    public int compareTo(Object o) {
        ExlOutParseResult tmp = (ExlOutParseResult) o;
        if (colSeq < tmp.colSeq) {
            return -1;
        } else if (colSeq > tmp.colSeq) {
            return 1;
        } else {
            return 0;
        }
    }
}
