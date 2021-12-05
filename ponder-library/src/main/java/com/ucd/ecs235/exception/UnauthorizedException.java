package com.ucd.ecs235.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "User does not have sufficient authorization for the action.")
public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final int ERROR_CODE = 4;
    private static final Integer STATUS_CODE = 403;

    private static final String MSG_KEY = "forbidden";

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
