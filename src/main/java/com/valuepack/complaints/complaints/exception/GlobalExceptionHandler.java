package com.valuepack.complaints.complaints.exception;

import com.valuepack.complaints.complaints.util.CompliantResponse;
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
    CompliantResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                             final HttpServletRequest request) {

        CompliantResponse compliantResponse = new CompliantResponse();
        compliantResponse.setStatus(HttpStatus.NO_CONTENT.value());
        compliantResponse.setError(HttpStatus.NO_CONTENT.name());
        compliantResponse.setMessage(exception.getMessage());
        return compliantResponse;
    }

    @ExceptionHandler({DefaultException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    CompliantResponse handleException(final Exception exception, final HttpServletRequest request) {

        CompliantResponse compliantResponse = new CompliantResponse();
        compliantResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        compliantResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        compliantResponse.setMessage(exception.getMessage());
        return compliantResponse;
    }

    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    CompliantResponse handleInvalidInputException(final Exception exception,
                                                  final HttpServletRequest request) {

        CompliantResponse compliantResponse = new CompliantResponse();
        compliantResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        compliantResponse.setError(HttpStatus.BAD_REQUEST.name());
        compliantResponse.setMessage(exception.getMessage());
        return compliantResponse;


    }
}