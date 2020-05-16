package com.fincitycar.demo.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public interface IErrors {

    public static CustomError createNewCustomError(String errorCode, HttpStatus status, String developerMsg, String customMsg){
        if(StringUtils.isBlank(developerMsg)) developerMsg = customMsg;
        CustomError error = new CustomError(errorCode,developerMsg,customMsg,status);
        return error;
    }

    public static CustomError RESOURCE_NOT_FOUND(String customMsg,String developerMsg) {
        return createNewCustomError("100", HttpStatus.BAD_REQUEST, developerMsg, customMsg);
    }
}
