package com.springlearn.spring_learn.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    String sayHello() {
        return "Hello spring boot 3";
    }
}
