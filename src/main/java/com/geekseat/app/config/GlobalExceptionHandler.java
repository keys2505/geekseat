package com.geekseat.app.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(ValidationException ex) {
        var body = new HashMap<String, Object>();

        body.put("message", "Validation failed: " +ex.getMessage());
        body.put("result", -1);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler()
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        var body = new HashMap<String, Object>();

        body.put("message", ex.getMessage());
        body.put("result", -1);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
