package com.fincitycar.demo.exception;

import com.fincitycar.demo.enums.ResponseStatus;
import com.fincitycar.demo.message.GenericResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CarNotFoundException.class})
    public <T> ResponseEntity<T> handleCarNotFoundExceptionException(final CarNotFoundException e, WebRequest request){
        CustomError error = e.getError();
        logger.error("Car Exception occurred for request: "+ request, e);
        return (ResponseEntity<T>) createResponseEntityForCustomError(error,error.getStatusCode(),e);
    }

    @ExceptionHandler({InvalidSearchTypeException.class})
    public <T> ResponseEntity<T> handleInvalidSearchTypeException(final InvalidSearchTypeException e,WebRequest request){
        CustomError error = e.getError();
        logger.error("Invalid search type exception occurred for request: "+ request, e);
        return (ResponseEntity<T>) createResponseEntityForCustomError(error,error.getStatusCode(),e);
    }


    public ResponseEntity<Object> createResponseEntityForCustomError(CustomError error, HttpStatus status, Exception e) {

        String developer_message = error.getDeveloper_message().isEmpty()?e.getMessage():error.getDeveloper_message();
        if (e != null) {
            e.printStackTrace();
        }

        logger.info(String.format("message: %s",error.getCustom_message()));
        logger.info(String.format("errorCode: %s",error.getError_code()));
        logger.info(String.format("developer_message: %s",developer_message));

        List<CustomError> errors = new ArrayList<>();
        errors.add(error);

        GenericResponse<?> response = new  GenericResponse(ResponseStatus.FAILURE,errors,null);
        return new ResponseEntity<Object>(response, new HttpHeaders(), status);

    }

}
