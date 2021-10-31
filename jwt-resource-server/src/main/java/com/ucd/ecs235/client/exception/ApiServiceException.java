package com.ucd.ecs235.client.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiServiceException extends RuntimeException {
    private static final long serialVersionUID = -7177578401192164920L;
    private String message;
    private String causeMessage;
    @JsonIgnore
    private HttpStatus httpStatus;
    private String code;
    @JsonIgnore
    private transient Object[] arguments;
    @JsonIgnore
    private StackTraceElement[] stackTrace;
    @JsonIgnore
    private Throwable cause;

    public ApiServiceException(String message, Throwable cause, HttpStatus httpStatus, String code, Object... arguments) {
        super(cause);
        this.message = message;
        this.httpStatus = httpStatus;
        this.code = code;
        this.arguments = arguments;
        this.causeMessage = cause == null ? null : cause.getMessage();
    }

    public ApiServiceException(String message, HttpStatus httpStatus, String code, Object... arguments) {
        this(message, (Throwable)null, httpStatus, code, arguments);
    }

    public ApiServiceException(HttpStatus httpStatus, String code, String message, Object... arguments) {
        this(message, (Throwable)null, httpStatus, code, arguments);
    }

    public ApiServiceException(Throwable cause, HttpStatus httpStatus, String code, Object... arguments) {
        this((String)null, cause, httpStatus, code, arguments);
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}