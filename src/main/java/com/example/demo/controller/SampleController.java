package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

  private final ObjectMapper objMap;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Parameters {
    private String param1;
    private String param2;
    private Integer param3;
    private Double param4;
  }

  @GetMapping
  public ResponseEntity<?> getSomething(@RequestParam("parameters") String parameters) throws JsonProcessingException {
    var input = objMap.readValue(parameters, Parameters.class);
    return ResponseEntity.ok(input);
  }

}
