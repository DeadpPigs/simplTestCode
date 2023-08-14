package com.pig.dead.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  RequestEnum {
    OK(200,"success"),
    FAIL(1001,"fail");
    private final Integer code;
    private final String message;
}
