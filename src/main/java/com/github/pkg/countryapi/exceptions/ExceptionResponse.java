package com.github.pkg.countryapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private Map<String, String> validationErrors;
    private HttpStatus status;
}