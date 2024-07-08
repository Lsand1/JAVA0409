package com.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Adminuser)实体类
 *
 * @author makejava
 * @since 2024-03-12 10:11:31
 */
public class Adminuser {
    /**
     * 管理员ID
     */
    private Integer id;
    /**
     * 管理员名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}

