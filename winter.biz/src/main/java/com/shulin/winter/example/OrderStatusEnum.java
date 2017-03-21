package com.shulin.winter.example;


import com.shulin.winter.annotions.EnumDataType;

public enum OrderStatusEnum implements EnumDataType {
    CJDD("CJDD", "创建订单"),
    DDBJ("DDBJ", "订单报价"),
    FPDD("FPDD", "分配订单"),
    DDSG("DDSG", "订单施工");

    private String key;
    private final String value;

    private OrderStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getEnumValue(Object key){
        if (key != null) {
            for (OrderStatusEnum op : OrderStatusEnum.values()) {
                if (op.getKey().equals(key)) {
                    return op.getValue();
                }
            }
            return null;
        }
        return null;
    }


}
