package com.valuepack.complaints.exception;

import com.valuepack.complaints.util.ComplaintResponse;
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
    ComplaintResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                             final HttpServletRequest request) {

        ComplaintResponse complaintResponse = new ComplaintResponse();
        complaintResponse.setStatus(HttpStatus.NO_CONTENT.value());
        complaintResponse.setError(HttpStatus.NO_CONTENT.name());
        complaintResponse.setMessage(exception.getMessage());
        return complaintResponse;
    }

    @ExceptionHandler({DefaultException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ComplaintResponse handleException(final Exception exception, final HttpServletRequest request) {

        ComplaintResponse complaintResponse = new ComplaintResponse();
        complaintResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        complaintResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        complaintResponse.setMessage(exception.getMessage());
        return complaintResponse;
    }

    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ComplaintResponse handleInvalidInputException(final Exception exception,
                                                  final HttpServletRequest request) {

        ComplaintResponse complaintResponse = new ComplaintResponse();
        complaintResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        complaintResponse.setError(HttpStatus.BAD_REQUEST.name());
        complaintResponse.setMessage(exception.getMessage());
        return complaintResponse;


    }
}