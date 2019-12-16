package com.clothesmake.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    private  T data;

    private Integer code;

    private  String msg;

    public Result(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return success("ok", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(200, msg, data);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> error(int code) {
        return new Result<>(code, "exception", null);
    }
}
