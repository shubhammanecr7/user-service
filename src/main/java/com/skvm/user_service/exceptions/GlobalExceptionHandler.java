package com.skvm.user_service.exceptions;

import com.skvm.user_service.error.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(UserNotFoundException e, HttpServletRequest httpServletRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                httpServletRequest.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUserDetailsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserDetails(InvalidUserDetailsException e, HttpServletRequest httpServletRequest){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.NO_CONTENT.value(),
                httpServletRequest.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }

    //optional catch all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralError(Exception e, HttpServletRequest httpServletRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                httpServletRequest.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}