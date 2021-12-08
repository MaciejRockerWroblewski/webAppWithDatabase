package com.example.webapp.web;

import com.example.webapp.api.model.User;
import com.example.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ModelAndView displayAddUserPage(){
        ModelAndView mav = new ModelAndView("addUser");
        mav.addObject("user", new User());
        return mav;
    }

    @GetMapping("/edit")
    public ModelAndView displayEditUserPage(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("addUser");
        mav.addObject("user", userService.getById(id));
        mav.addObject("isEdited", true);
        return mav;
    }

    @PostMapping
    public RedirectView handleAddUser(@ModelAttribute("user") User user){
        if (user.getId() == null) {
            userService.create(user);
        }else{
            userService.update(user);
        }
        return new RedirectView("/");
    }
}
