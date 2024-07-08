package com.test.entity;

import java.io.Serializable;

/**
 * (OrdersItem)实体类
 *
 * @author makejava
 * @since 2024-05-14 10:46:17
 */
public class OrdersItem {

    /**
     * 详情ID
     */
    private Integer id;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 数量
     */
    private Integer num;
    private Orders orders;
    private Goods goods;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}

