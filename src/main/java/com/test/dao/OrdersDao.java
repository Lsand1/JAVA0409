package com.test.dao;

import com.test.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-14 08:12:45
 */
@Mapper
public interface OrdersDao {

    Orders queryById(Integer id);
    List<Orders> queryAllByLimit(Orders orders);

    int insert(Orders orders);

    int update(Orders orders);

    int deleteById(Orders orders);

    List<Orders> queryAll(Orders orders);
}

