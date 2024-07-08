package com.test.entity;

import java.io.Serial;
import java.io.Serializable;

public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 序列化版本ID

    private boolean success; // 响应成功标志
    private String message;  // 响应消息
    private T data;         // 响应数据

    // 私有构造函数，使用静态方法创建实例
    public Response(boolean b, String passwordChangeFailed, Object o) {
        // 留空，允许通过setter方法设置属性
    }

    public Response(boolean b, String insertFailed, int i) {
    }

    // 静态工厂方法，创建失败响应
    public static <U> Response<U> fail() {
        Response<U> response = new Response<>(false, "Password change failed", null);
        response.setSuccess(false);
        return response;
    }

    // 静态工厂方法，创建带有消息的失败响应
    public static <U> Response<U> fail(String msg) {
        Response<U> response = new Response<>(false, "Password change failed", null);
        response.setSuccess(false);
        response.setMessage(msg);
        return response;
    }

    // 静态工厂方法，创建成功的响应
    public static <U> Response<U> success(U data) {
        Response<U> response = new Response<>(false, "Password change failed", null);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    // 静态工厂方法，创建只有消息的成功响应
    public static <U> Response<U> success(String msg) {
        Response<U> response = new Response<>(false, "Password change failed", null);
        response.setSuccess(true);
        response.setMessage(msg);
        return response;
    }

    // 静态工厂方法，创建带有消息和数据的成功响应
    public static <U> Response<U> success(String msg, U data) {
        Response<U> response = new Response<>(false, "Password change failed", null);
        response.setSuccess(true);
        response.setMessage(msg);
        response.setData(data);
        return response;
    }

    // Getter和Setter方法
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}