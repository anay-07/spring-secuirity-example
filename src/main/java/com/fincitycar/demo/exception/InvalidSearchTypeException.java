package com.fincitycar.demo.exception;

import org.springframework.http.HttpStatus;

public class InvalidSearchTypeException extends Exception {

    private static final long serialVersionUID = 6055855278660149730L;
    private CustomError error;

    private HttpStatus statusCode;

    public InvalidSearchTypeException(CustomError error) {
        super();
        this.error = error;
    }

    public InvalidSearchTypeException(CustomError error, String message) {
        super(message);
        this.error = error;
    }

    public InvalidSearchTypeException(CustomError error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public InvalidSearchTypeException(CustomError error, String message ,Throwable cause) {
        super(message,cause);
        this.error = error;
    }

    public CustomError getError() {
        return error;
    }
}
