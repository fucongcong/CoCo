package com.clothesmake.exception;

public class ServiceException extends RuntimeException {

    private String msg;

    private Integer code;

    public ServiceException(String msg) {
        this(500, msg);
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}