# Case Study :: Exception Handling

![Technology - Spring Boot](https://img.shields.io/badge/Technology-Spring_Boot-blue)
![Tracing Difficulty - Easy](https://img.shields.io/badge/Tracing_Difficulty-Easy-green)
![Implementation Difficulty - Easy](https://img.shields.io/badge/Implementation_Difficulty-Easy-green)


## The Problem

If unhandled error is thrown, there is probability that the error could cause chaos, like blank page or force close.

## The Objective

Fix the error happened with exception handling.

## The Expected Result

Any unexpected error happened is handled and not causing chaos.
# Solution
  Create GlobalExceptionHandler class to solve the problem
  '''java
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
        
        // Return a simplified JSON response with the error message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("{\"error\": \"" + errorMessage + "\"}");
    }
    
}

# Result
![WhatsApp Image 2023-09-16 at 17 18 34_7ba2e7ea](https://github.com/deo23/Exception-Handling/assets/95121147/f71900ae-d1e2-4f6e-b214-1659aaeac528)

