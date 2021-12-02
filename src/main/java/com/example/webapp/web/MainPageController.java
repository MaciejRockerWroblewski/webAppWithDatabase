package com.example.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String displayMainPage(){
        return "main";
    }
}
