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
    private String isDeleted;
    private Date gmtCreate;
    private Long creator;
    private Date gmtModified;
    private Long modifier;
    @ExlOut(colSeq = 1, colName = "结算时间")
    private Date payTime;//结算时间
    private Long shopId;//店铺id
    private Long orderType;//工单类型
    private Long parentId;//上级工单id
    @ExlOut(colSeq = 2, colName = "工单编号")
    private String orderSn;//工单编号
    private Long customerId;//用户id
    private Long customerCarId;//客户车辆id
    private Date expectedTime;//预计出厂时间
    @ExlOut(colSeq = 3, colName = "预估物料总价")
    private BigDecimal goodsAmount;//预估物料总价
    private BigDecimal serviceAmount;//预估其它费用价格\n
    @ExlOut(colSeq = 4, colName = "税价")
    private BigDecimal taxAmount;//税价
    private BigDecimal totalAmount;//物料和服务和附加费用总和
    @ExlOut(colSeq = 5, colName = "备注")
    private String postscript;//备注
    @ExlOut(colSeq = 6, colName = "订单状态",
            enumName = "com.shulin.winter.example.OrderStatusEnum")
    private String orderStatus;//'订单状态：cjdd
    private String carLicense;//车牌号
    private Long carBrandId;//车品牌id
    private Long carSeriesId;//车系列id
    private Long carPowerId;//车排量id
    private Long carYearId;//车年款id
    private Long carModelsId;//车款式id
    private String carBrand;//车品牌
    private String carSeries;//车系列
    private String carPower;//车排量
    private String carYear;//车年款
    private String carModels;//车款式
    private String carCompany;//车厂家
    private String importInfo;//进出口
    private String customerName;//客户名称
    private String customerMobile;//客户手机号码
    private String vin;//车架号
    private String engineNo;//发动机号
    private Long receiver;//接单人id
    private Long invoiceType;//发票类型，0为不开票，1为普通发票，2为增值发票
    private BigDecimal discount;//优惠金额
    private String receiverName;//接单人名字
    private String operatorName;//开单人名称
    private BigDecimal orderAmount;//实际工单金额
    private Integer payStatus;//支付状态，0为未支付，2为已支付，1为挂账
    private Date finishTime;//完工时间
    private Long goodsCount;//物料总数
    private Long serviceCount;//服务总数
    private String carAlias;//车别名
    private BigDecimal preDiscountRate;//预折扣
    private BigDecimal preTaxAmount;//预税费
    private BigDecimal prePreferentiaAmount;//预优惠金额
    private BigDecimal preCouponAmount;//预代金券金额
    private BigDecimal preTotalAmount;//预计结算金额
    private BigDecimal payAmount;//实付金额
    private BigDecimal signAmount;//挂账金额
    private Long otherInsuranceCompanyId;//对方保险公司id
    private String otherInsuranceCompanyName;//对方保险公司名称
    private BigDecimal goodsDiscount;//物料折扣
    private BigDecimal serviceDiscount;//服务折扣
    private BigDecimal feeAmount;//附加费用总金额
    private BigDecimal feeDiscount;//附加费用优惠
    private String contactName;//联系人姓名
    private String contactMobile;//联系人电话
    private Long insuranceCompanyId;//承保公司id
    private String insuranceCompanyName;//承保公司名称
    private String mileage;//里程数
    private String carColor;//车辆颜色
    private Date buyTime;//购买时间
    private String customerAddress;//客户地址
    private String oilMeter;//油表油量
    private Integer isNotice;//'完工单完工是否已通知顾客，未通知为0，
    private Integer isVisit;//是否已回访（1代表已回访，0或null代表未回访）
    private String isLock;//工单是否锁定状态(只有处于订单完成及以后状态的订单，才可能有锁定态)
    private String imgUrl;//车牌图片url
    private Integer orderTag;//工单标签，1为普通工单，2为洗车工单，3为快修快保单，4为保险维修单
    private String ver;//版本号
    private Integer refer;//来源：0:web,1:android,2:ios
    private String upkeepMileage;//下次保养里程
    private Date createTime;//开单日期
    private Integer proxyType;//委托状态：0：无1：委托2：受委托
    private Long channelId;//渠道商id
    private String channelName;//渠道商名称
    private BigDecimal orderDiscountAmount;//工单优惠总金额
    private Date confirmTime;//工单确认时间
    private Date expectTime;//期望交车时间
    private BigDecimal downPayment;//预付定金
}
