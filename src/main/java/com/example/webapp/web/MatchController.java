package com.example.webapp.web;

import com.example.webapp.api.Match;
import com.example.webapp.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping("/all")
    public ModelAndView displayAllMatchesPage(){
        ModelAndView modelAndView = new ModelAndView("matches");
        modelAndView.addObject("matches", matchService.getAll());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView displayEditMatchPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("addMatch");
        modelAndView.addObject("match", matchService.getById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView displayAddMatchPage(){
        ModelAndView modelAndView = new ModelAndView("addMatch");
        modelAndView.addObject("match", new Match());
    return modelAndView;
    }



    @PostMapping
    public RedirectView handleAddMatch(@ModelAttribute("match") Match match){
        if (match.getId() == null) {
            matchService.create(match);
        } else{
            matchService.update(match);
        }
        return new RedirectView("/match/all");

    }


}
