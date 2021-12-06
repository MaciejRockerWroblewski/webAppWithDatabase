package com.example.webapp.web.model;

import com.example.webapp.api.model.NewBet;
import com.example.webapp.service.BetService;
import com.example.webapp.service.MatchService;
import com.example.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/bet")
@RequiredArgsConstructor
public class BetController {

    private final MatchService matchService;
    private final UserService userService;
    private final BetService betService;

    @GetMapping
    public ModelAndView displayBetPage() {
        ModelAndView mav = new ModelAndView("addBet");
        mav.addObject("bet", new NewBet());
        mav.addObject("users", userService.getAll()
                .stream()
                .map(usr -> SelectOption.builder().id(usr.getId()).label(usr.getLogin()).build())
                .collect(Collectors.toList()));
        mav.addObject("matches", matchService.getAll()
                .stream()
                .map(match -> SelectOption.builder().id(match.getId())
                        .label(match.getFirstTeam() + "-" + match.getSecondTeam()).build())
                .collect(Collectors.toList()));
        return mav;
    }

    @PostMapping
    public RedirectView handleAddBet(@ModelAttribute("bet") NewBet bet) {
        betService.createBet(bet);
        return new RedirectView("/");
    }

}