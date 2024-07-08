package com.test.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2024-05-14 08:12:46
 */
public class Orders {
    /**
     * 订单ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单状态 1：未付款  2 ：已付款  3 已发货  4已签收 5交易失败
     */
    private Integer status;
    /**
     * 订单金额
     */
    private Double amount;
    /**
     * 下单时间
     */
    private Date addtime;
    private Users users;

    private List<OrdersItem> ordersItemList;

    public List<OrdersItem> getOrdersItemList() {
        return ordersItemList;
    }

    public void setOrdersItemList(List<OrdersItem> ordersItemList) {
        this.ordersItemList = ordersItemList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}

