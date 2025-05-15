package com.sx.guanli.pojo;
/**
 * @author Fpeng
 * @description: 统一响应结果类
 * @date 2025年3月29日 21点04分
 */

public class Result<T> {
    private Integer code; //业务状态码  0-成功  1-失败
    private String message; //提示信息
    private T data; //响应数据

    // 无参构造函数
    public Result() {
    }

    // 全参构造函数
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速返回操作成功响应结果（带数据）
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    // 快速返回操作成功响应结果（无数据）
    public static Result<Void> success() {
        return new Result<>(0, "操作成功", null);
    }

    // 快速返回操作失败响应结果
    public static <E> Result<E> error(String message) {
        return new Result<>(1, message, null);
    }

    // Getter & Setter
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}