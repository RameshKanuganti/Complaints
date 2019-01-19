package com.valuepack.complaints.exception;

import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public @ResponseBody
    VehicleResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                           final HttpServletRequest request) {

        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setStatus(HttpStatus.NO_CONTENT.value());
        vehicleResponse.setError(HttpStatus.NO_CONTENT.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;
    }

    @ExceptionHandler({DefaultException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    VehicleResponse handleException(final Exception exception, final HttpServletRequest request) {

        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vehicleResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;
    }

    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    VehicleResponse handleInvalidInputException(final Exception exception,
                                                final HttpServletRequest request) {

        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        vehicleResponse.setError(HttpStatus.BAD_REQUEST.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;


    }
}