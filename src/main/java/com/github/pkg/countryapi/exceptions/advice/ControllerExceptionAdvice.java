package com.github.pkg.countryapi.exceptions.advice;

import com.github.pkg.countryapi.exceptions.BadRequestException;
import com.github.pkg.countryapi.exceptions.ExceptionResponse;
import com.github.pkg.countryapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundException ex) {
        return ExceptionResponse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestException(BadRequestException ex) {
        return ExceptionResponse.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).build();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse validationException(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            validationErrors.put(field, message);
        });

        return ExceptionResponse.builder()
                .message("One or more errors occurred with your request.")
                .validationErrors(validationErrors)
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
