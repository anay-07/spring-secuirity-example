package com.fincitycar.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class CustomError {

    @Getter
    String error_code;

    @Getter
    String developer_message;

    @Getter
    @Setter
    private HttpStatus statusCode;

    @Getter
    String custom_message;

    final static String app = "fincity";



    public CustomError(String error_code, String developer_message, String custom_message, HttpStatus statusCode) {
        super();
        this.error_code = app+error_code;
        this.developer_message = developer_message;
        this.statusCode = statusCode;
        this.custom_message = custom_message;
    }



    public CustomError(String error_code, HttpStatus statusCode, String custom_message) {
        super();
        this.error_code = error_code;
        this.statusCode = statusCode;
        this.custom_message = custom_message;
    }



}
