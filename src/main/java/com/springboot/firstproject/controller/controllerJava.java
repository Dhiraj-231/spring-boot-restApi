package com.springboot.firstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerJava {

    @GetMapping("/")
    public String helloWorld() {
        return "This is first restApi project from the Spring...";
    }
}
