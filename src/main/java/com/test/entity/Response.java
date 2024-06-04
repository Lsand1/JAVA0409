package com.test.entity;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private boolean success = true;
    private String message;
    private T data;


    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String msg) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(msg);
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(String msg) {
        Response<T> response = new Response<>();
        response.setMessage(msg);
        return response;
    }

    public static <T> Response<T> success(String msg,T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(msg);
        return response;
    }

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
