package com.example.webapp.api.model;


import com.example.webapp.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bet")
@RequiredArgsConstructor
public class BetEndpoint {

    private final BetService betService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBet(@Valid @RequestBody Bet bet) {
        betService.createBet(bet);
    }




}
