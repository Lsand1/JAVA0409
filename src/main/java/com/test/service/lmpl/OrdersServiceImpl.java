package com.test.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dao.OrdersItemDao;
import com.test.entity.Orders;
import com.test.dao.OrdersDao;
import com.test.entity.Users;
import com.test.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2024-05-14 08:12:48
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private OrdersItemDao ordersItemDao;


    @Override
    public Orders queryById(Integer id) {
        return this.ordersDao.queryById(id);
    }

    @Override
    public PageInfo<Orders> queryByPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> ordersList= ordersDao.queryAllByLimit(orders);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        return pageInfo;
    }

    @Override
    public Orders insert(Orders orders) {
        this.ordersDao.insert(orders);
        return orders;
    }

    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getId());
    }


    @Transactional
    @Override
    public boolean deleteById(Orders orders) {
        boolean flag = true;

        try {
            this.ordersItemDao.delOrdersItemByoId(orders.getId());
            this.ordersDao.deleteById(orders);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
