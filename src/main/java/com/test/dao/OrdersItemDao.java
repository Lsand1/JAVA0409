package com.test.dao;


import com.test.entity.OrdersItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * (OrdersItem)表数据库访问层
 *
 * @author suxuexia
 * @since 2024-03-26 10:59:35
 */
@Mapper
public interface OrdersItemDao {

    // 根据订单号删除订单详请
    int delOrdersItemByoId(Integer orderId);

    List<OrdersItem> queryByoId(OrdersItem ordersItem);

    // 根据会员ID删除订单详请
    int deleteByUserId(Integer userId);

}

