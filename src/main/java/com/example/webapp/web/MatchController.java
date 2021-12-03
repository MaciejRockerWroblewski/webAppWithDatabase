package com.example.webapp.web;

import com.example.webapp.api.Match;
import com.example.webapp.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ModelAndView displayAddMatchPage(){
        ModelAndView modelAndView = new ModelAndView("addMatch");
        modelAndView.addObject("match", new Match());
    return modelAndView;
    }

    @PostMapping
    public RedirectView handleAddMatch(@ModelAttribute("match") Match match){
        matchService.create(match);

        return new RedirectView("/");

    }


}
