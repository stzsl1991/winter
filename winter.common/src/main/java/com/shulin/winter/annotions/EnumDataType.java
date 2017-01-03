package com.shulin.winter.annotions;

/**
 * 用于从Enum中取出value，被解析的Enum需要实现这个借口
 * Created by shulin on 16/12/26.
 */
public interface EnumDataType {
    String getEnumValue(Object key);
}
