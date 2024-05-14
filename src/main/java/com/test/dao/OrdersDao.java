package com.test.dao;


import com.test.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author suxuexia
 * @since 2024-03-26 09:35:01
 */

@Mapper
public interface OrdersDao {

    List<Orders> queryAll(Orders orders);

    int deleteById(Orders orders);

    // 根据订单ID查询订单信息，订单详请页面使用
    Orders queryById(Integer id);

}

