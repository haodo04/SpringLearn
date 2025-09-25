package com.springlearn.spring_learn.exception;

public enum ErrorCode {
    USER_EXISTED(1002, "user existed"),
    UNCATEGORIZED_ERROR(9999, "uncategorized error"),
    UNAUTHENTICATED_ERROR(1006, "unauthenticated error"),
    INVALID_KEY(1001, "invalid message key"),
    USERNAME_INVALID(1003, "username must be at least 3 characters"),
    USER_NOT_EXISTED(1005, "user not exist"),
    PASSWORD_INVALID(1004, "password must be at least 8 characters");

    private int code;

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
