package com.qingmuy.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 200;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> error(ErrorCode e) {
        Result result = new Result();
        result.message = e.getMessage();
        result.code = e.getCode();
        return result;
    }

}
