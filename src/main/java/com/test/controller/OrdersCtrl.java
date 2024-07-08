package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Orders;
import com.test.entity.Users;
import com.test.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/orders")
public class OrdersCtrl {
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
    public String delOrders(@PathVariable("id") Integer id, Model model) {
        Orders o = new Orders();
        o.setId(id);
        boolean flag = this.ordersService.deleteById(o);
        if (flag) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "该订单不允许删除！");
        }
        return "forward:/admin/orders/getOrdersList";
    }
    @GetMapping("getOrdersItemList/{id}")
    public String getOrdersItemList (@PathVariable("id") Integer id){
        return "forward:/admin/orders/getOrdersList";

    }
}
