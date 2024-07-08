package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Orders;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2024-05-14 08:12:48
 */
public interface OrdersService {

    Orders queryById(Integer id);
    PageInfo<Orders> queryByPage(Orders orders, Integer pageNum, Integer pageSize);
    Orders insert(Orders orders);
    Orders update(Orders orders);
    boolean deleteById(Orders orders);

}
