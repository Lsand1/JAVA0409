package com.test.dao;

import com.test.entity.OrdersItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (OrdersItem)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-14 10:46:17
 */
@Mapper
public interface OrdersItemDao {

    OrdersItem queryById(Integer id);
    List<OrdersItem> queryByoId(OrdersItem orderId);

    List<OrdersItem> queryAllByLimit(OrdersItem ordersItem);
    int update(OrdersItem ordersItem);
    // 根据订单号删除订单详请
    int delOrdersItemByoId(Integer orderId);
    // 根据会员ID删除订单详请
    int deleteByUserId(Integer userId);
}

