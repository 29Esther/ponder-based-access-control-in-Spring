package com.ucd.ecs235.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Object not found")
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final int ERROR_CODE = 3;
    private static final Integer STATUS_CODE = 404;

    private static final String MSG_KEY = "object-not-found";

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
