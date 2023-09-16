package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        // Extract the exception message
        String errorMessage = ex.getMessage();
        if (errorMessage == null) {
            errorMessage = ex.toString();
        }
        
        
        // Return a simplified JSON response with the error message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("{\"error\": \"" + errorMessage + "\"}");
    }
    
}


// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.context.request.WebRequest;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
//         // You can customize the error response here
//         String errorMessage = "An error occurred.";
//         return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
