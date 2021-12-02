package com.example.webapp.api.validator;


import com.example.webapp.api.model.BetDetails;
import com.example.webapp.api.model.NewBet;
import com.example.webapp.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bet")
@RequiredArgsConstructor
public class BetEndpoint {

    private final BetService betService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBet(@Valid @RequestBody NewBet bet) {
        betService.createBet(bet);
    }

    @DeleteMapping
    public void deleteBet(@RequestParam Long id) {
        betService.deleteBet(id);

    }

    @GetMapping("/user/{userId}")
    public List<BetDetails> getForUsers(@PathVariable Long userId) {
        return betService.getAllForUser(userId);
    }

    @GetMapping("/match/{matchId}")
    public List<BetDetails> getAllForMatch(@PathVariable Long matchId) {
        return betService.getAllForMatch(matchId);
    }


}
