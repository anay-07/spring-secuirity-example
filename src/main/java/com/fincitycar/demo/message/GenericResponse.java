package com.fincitycar.demo.message;

import java.util.List;


import com.fincitycar.demo.enums.ResponseStatus;
import com.fincitycar.demo.exception.CustomError;
import lombok.Getter;


@Getter
public class GenericResponse<T> {

    ResponseStatus status;
    List<CustomError> errors;
    T data;
    public GenericResponse(ResponseStatus status, List<CustomError> errors, T data) {
        super();
        this.status = status;
        this.errors = errors;
        this.data = data;
    }

    public GenericResponse(ResponseStatus status){
        super();
        this.status = status;
    }

    public GenericResponse(List<CustomError> errors){
        super();
        this.status = ResponseStatus.FAILURE;
        this.errors = errors;
    }

    public GenericResponse(T data){
        super();
        this.status = ResponseStatus.SUCCESS;
        this.data = data;
    }

}