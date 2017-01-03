package com.shulin.winter.annotions;

import java.lang.annotation.*;

/**
 * Excel导出注解
 * Created by shulin on 16/12/25.
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExlOut {
    /**
     * 列序号，比如第1列是姓名，第2列是电话号码，第3列是地址
     *
     * @return
     */
    int colSeq();

    /**
     * 列名
     *
     * @return
     */
    String colName();

    /**
     * 日期类型格式化
     *
     * @return
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:SS";


    /**
     * 枚举的名称
     *
     * @return
     */
    String enumName() default "";

    /**
     * 是否有自增序列
     *
     * @return
     */
    boolean autoIncrement() default false;
}
