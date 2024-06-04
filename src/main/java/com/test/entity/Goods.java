package com.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author suxuexia
 * @since 2024-03-26 10:20:48
 */
public class Goods implements Serializable  {

    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 类别ID,外键
     */
    private Integer categoryId;
    /**
     * 商品编号
     */
    private String code;
    /**
     * 商品名
     */
    public String name;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 库存量
     */
    private Integer quantity;
    /**
     * 销售量
     */
    private Integer saleQuantity;
    /**
     * 上架时间
     */
    private Date addtime;
    /**
     * 是否热销
     */
    private Integer hot;
    /**
     * 商品图片
     */
    private String image;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

