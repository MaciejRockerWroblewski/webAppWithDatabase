package com.example.webapp.web;

import com.example.webapp.api.Match;
import com.example.webapp.service.BetService;
import com.example.webapp.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;
    private final BetService betService;

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
    @GetMapping("/details")
    public ModelAndView displayDetailsPage(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("matchDetails");
        mav.addObject("match", matchService.getById(id));
        mav.addObject("bets", betService.getAllForMatch(id));
        return mav;
    }
    @GetMapping("/delete")
    public RedirectView deleteMatch(@RequestParam Long id) {
        matchService.delete(id);
        return new RedirectView("/match/all");
    }

    @GetMapping
    public ModelAndView displayAddMatchPage(){
        ModelAndView modelAndView = new ModelAndView("addMatch");
        modelAndView.addObject("match", new Match());
    return modelAndView;
    }



    @PostMapping
    public String handleAddMatch(@Valid @ModelAttribute("match") Match match, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addMatch";
        }
        if (match.getId() == null) {
            matchService.create(match);
        } else{
            matchService.update(match);
        }
        return "redirect:/match/all";

    }


}
