package com.shulin.winter.example.impl;

import com.shulin.winter.common.BdUtil;
import com.shulin.winter.dao.order.OrderInfoDao;
import com.shulin.winter.entity.order.OrderInfo;
import com.shulin.winter.example.OrderInfoVo;
import com.shulin.winter.exl.ExlPageQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 工单具体实现类
 * Created by shulin on 16/12/25.
 */
@Component
@Slf4j
public class OrderInfoPageQueryImpl implements ExlPageQuery<OrderInfoVo> {
    @Autowired
    private OrderInfoDao orderInfoDao;

    @Override
    public List<OrderInfoVo> getBeansByPage(Map<String, Object> params) {
        List<OrderInfo> orderInfoList = orderInfoDao.select(params);
        List<OrderInfoVo> orderInfoVos = BdUtil.bo2do4List(orderInfoList, OrderInfoVo.class);
        return orderInfoVos;
    }
}
