package com.example.webapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldEndpoint {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World from first controller";
    }
}
