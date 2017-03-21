package com.shulin.winter.example;

import com.shulin.winter.annotions.ExlOut;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shulin on 16/12/25.
 */
@Setter
@Getter
@ExlOut(colSeq = 0, colName = "序列号", autoIncrement = true)
public class OrderInfoVo {
    private Long id;
    @ExlOut(colSeq = 1, colName = "结算时间")
    private Date payTime;//结算时间
    @ExlOut(colSeq = 2, colName = "工单编号")
    private String orderSn;//工单编号
    @ExlOut(colSeq = 3, colName = "预估物料总价")
    private BigDecimal goodsAmount;//预估物料总价
    @ExlOut(colSeq = 4, colName = "税价")
    private BigDecimal taxAmount;//税价
    @ExlOut(colSeq = 5, colName = "备注")
    private String postscript;//备注
    @ExlOut(colSeq = 6, colName = "订单状态",
            enumName = "com.shulin.winter.example.OrderStatusEnum")
    private String orderStatus;//'订单状态：cjdd
}
