package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Orders;


/**
 * (Orders)表服务接口
 *
 * @author suxuexia
 * @since 2024-03-26 09:35:01
 */
public interface OrdersService {

    PageInfo<Orders> queryByPage(Orders orders, Integer pageNum, Integer pageSize);

    boolean deleteById(Orders orders);
}
