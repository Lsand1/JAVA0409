package com.test.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author suxuexia
 * @since 2024-05-07 10:07:15
 */
@Schema(description = "会员")
public class Users implements Serializable {
    private static final long serialVersionUID = 939753003031575883L;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer id;
    /**
     * 登录名
     */
    @Schema(description = "登录名")
    private String loginName;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 积分
     */
    private Integer credit;
    /**
     * 注册日期
     */
    private Date regtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

}

