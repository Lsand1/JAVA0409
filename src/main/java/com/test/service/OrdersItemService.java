package com.test.service;

import com.test.entity.OrdersItem;

import java.util.List;

/**
 * (OrdersItem)表服务接口
 *
 * @author makejava
 * @since 2024-05-14 10:46:18
 */
public interface OrdersItemService {

    List<OrdersItem> queryByPage(OrdersItem ordersItem);


}
