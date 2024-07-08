package com.test.service.lmpl;

import com.test.entity.OrdersItem;
import com.test.dao.OrdersItemDao;
import com.test.service.OrdersItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (OrdersItem)表服务实现类
 *
 * @author makejava
 * @since 2024-05-14 10:46:18
 */
@Service("ordersItemService")
public class OrdersItemServiceImpl implements OrdersItemService {
    @Resource
    private OrdersItemDao ordersItemDao;

    @Override
    public List<OrdersItem> queryByPage(OrdersItem ordersItem) {
        return this.ordersItemDao.queryAllByLimit(ordersItem);
    }
}
