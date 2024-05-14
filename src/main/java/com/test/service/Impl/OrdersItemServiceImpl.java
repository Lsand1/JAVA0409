package com.test.service.Impl;

import com.test.dao.OrdersItemDao;
import com.test.entity.OrdersItem;
import com.test.service.OrdersItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (OrdersItem)表服务实现类
 *
 * @author suxuexia
 * @since 2024-03-26 10:59:35
 */
@Service("ordersItemService")
public class OrdersItemServiceImpl implements OrdersItemService {
    @Resource
    private OrdersItemDao ordersItemDao;

    public List<OrdersItem> queryAll(OrdersItem ordersItem) {
        return this.ordersItemDao.queryByoId(ordersItem);
    }

}
