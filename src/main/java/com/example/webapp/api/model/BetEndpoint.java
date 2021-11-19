package com.example.webapp.api.model;


import com.example.webapp.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bet")
@RequiredArgsConstructor
public class BetEndpoint {

    private final BetService betService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBet(@RequestBody Bet bet) {
        betService.createBet(bet);
    }




}
