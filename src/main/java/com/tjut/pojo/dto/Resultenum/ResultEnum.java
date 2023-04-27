package com.tjut.pojo.dto.Resultenum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS("00000", "请求正常"),
    FAILED("A1000", "请求失败"),
    TOKEN_WRONG("D0400", "token过期"),
    TOKEN_NULL("D0500", "token不存在");
    private final String code;
    private final String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}