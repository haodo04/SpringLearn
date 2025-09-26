package com.springlearn.spring_learn.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1002, "user existed", HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_ERROR(9999, "uncategorized", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED_ERROR(1006, "unauthenticated", HttpStatus.UNAUTHORIZED),
    INVALID_KEY(1001, "invalid message key", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "user not exist", HttpStatus.NOT_FOUND),
    PASSWORD_INVALID(1004, "password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN);

    private int code;

    private String message;

    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
