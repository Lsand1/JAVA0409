package com.test.controller;

import com.test.entity.OrdersItem;
import com.test.service.OrdersItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (OrdersItem)表控制层
 *
 * @author suxuexia
 * @since 2024-03-26 10:59:35
 */
@Controller
@RequestMapping("/admin/ordersItem")
public class OrdersItemController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersItemService ordersItemService;

    @GetMapping("getOrdersItemList/{id}")
    public String getOrdersItemList(@PathVariable("id") Integer orderId, Model model) {
        OrdersItem ordersItem = new OrdersItem();
        ordersItem.setOrderId(orderId);
        List<OrdersItem> ordersItemList = this.ordersItemService.queryAll(ordersItem);
        model.addAttribute("ordersItemList", ordersItemList);
        return "ordersItemList";
    }
}

