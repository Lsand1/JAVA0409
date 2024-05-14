package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Orders;
import com.test.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * (Orders)表控制层
 *
 * @author suxuexia
 * @since 2024-03-26 09:35:01
 */
@Controller
@RequestMapping("/admin/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;


    @GetMapping("/getOrdersList")
    public String getOrdersList(Model model, @RequestParam(required = false) Orders orders,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize) {


        PageInfo<Orders> ordersListPage = this.ordersService.queryByPage(orders, pageNum, pageSize);
        model.addAttribute("ordersListPage", ordersListPage);
        return "ordersList";
    }

    @GetMapping("delOrders/{id}")
    public String deleteById(@PathVariable("id") Integer id, Model model) {
        Orders o = new Orders();
        o.setId(id);
        boolean flag = this.ordersService.deleteById(o);
        if (flag) {
            model.addAttribute("msg", "订单删除成功！");
        } else {
            model.addAttribute("msg", "订单删除失败！");
        }
        return "forward:/admin/orders/getOrdersList";
    }

    @GetMapping("getOrdersItemList/{id}")
    public String getOrdersItemList(@PathVariable("id") Integer id) {
        return "forward:/admin/orders/getOrdersList";
    }
}

