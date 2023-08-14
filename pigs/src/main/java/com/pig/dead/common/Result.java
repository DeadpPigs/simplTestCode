package com.pig.dead.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> ok() {
        return new Result<>(RequestEnum.OK.getCode(), RequestEnum.OK.getMessage(), null);
    }

    public static <T> Result<T> ok(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> ok(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> ok(T data) {
        return ok(200, "success", data);
    }

    public static <T> Result<T> ok(RequestEnum requestEnum) {
        return ok(requestEnum.getCode(), requestEnum.getMessage());
    }

    public static <T> Result<T> ok(RequestEnum requestEnum, T data) {
        return new Result<>(requestEnum.getCode(), requestEnum.getMessage(), data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(RequestEnum.FAIL.getCode(), RequestEnum.FAIL.getMessage(), null);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> fail(RequestEnum requestEnum) {
        return ok(requestEnum.getCode(), requestEnum.getMessage());
    }
}
