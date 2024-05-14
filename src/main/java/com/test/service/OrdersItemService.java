package com.test.service;


import com.test.entity.OrdersItem;

import java.util.List;

/**
 * (OrdersItem)表服务接口
 *
 * @author suxuexia
 * @since 2024-03-26 10:59:35
 */
public interface OrdersItemService {

    List<OrdersItem> queryAll(OrdersItem ordersItem);

}
