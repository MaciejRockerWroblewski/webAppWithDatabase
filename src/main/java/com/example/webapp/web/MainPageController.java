package com.example.webapp.web;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String displayMainPage(ModelMap modelMap){
        modelMap.addAttribute("currentDate", LocalDate.now());
        return "main";
    }
}
