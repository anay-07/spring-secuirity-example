package com.fincitycar.demo.exception;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends Exception {

    private static final long serialVersionUID = 6055855278660149720L;
    private CustomError error;

    private HttpStatus statusCode;

    public CarNotFoundException(CustomError error) {
        super();
        this.error = error;
    }

    public CarNotFoundException(CustomError error, String message) {
        super(message);
        this.error = error;
    }

    public CarNotFoundException(CustomError error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public CarNotFoundException(CustomError error, String message ,Throwable cause) {
        super(message,cause);
        this.error = error;
    }

    public CustomError getError() {
        return error;
    }

}
