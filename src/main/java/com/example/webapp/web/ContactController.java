package com.example.webapp.web;

import com.example.webapp.config.AdminProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class ContactController {
    private final AdminProperties adminProperties;

    @GetMapping("/contact")
    public ModelAndView displayContactPage(){
        ModelAndView mav = new ModelAndView("contact");
        mav.addObject("email", adminProperties.getEmail());
        mav.addObject("phone", adminProperties.getPhone());
        mav.addObject("company", adminProperties.getCompanyName());
        return mav;
    }
}
