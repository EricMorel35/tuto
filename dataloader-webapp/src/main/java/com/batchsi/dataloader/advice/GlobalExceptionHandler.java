package com.batchsi.dataloader.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.batchsi.dataloader.exception.ParameterNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParameterNotFoundException.class)
    public ResponseEntity<Object> handle(Exception e, WebRequest request) {
        DataLoaderErrorMessage error = new DataLoaderErrorMessage();
        error.setErrorCode(e.getMessage());
        error.setErrorMessage(e.getMessage());

        return handleExceptionInternal(e, error, null, HttpStatus.NOT_FOUND, request);
    }

}
