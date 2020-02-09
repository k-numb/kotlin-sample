package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaHelloController {

  @GetMapping("/java")
  public String sayHello() {
    return "Hello, Java!";
  }
}
