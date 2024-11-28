package com.aktanyusuf.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    RESOURCE_NOT_FOUND("1001", "No Record Exists"),
    GENERAL_EXCEPTION("9999","General Exception");

    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
