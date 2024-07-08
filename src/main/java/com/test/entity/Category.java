package com.test.entity;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2024-04-02 10:05:17
 */
public class Category  {
    /**
     * 类别ID
     */
    private Integer id;
    /**
     * 类别名称
     */
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

