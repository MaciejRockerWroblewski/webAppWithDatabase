package com.example.webapp.service;

import com.example.webapp.api.model.Bet;
import com.example.webapp.exception.MatchNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetService {

    private final MatchService matchService;

    public void createBet(Bet bet){
        if (!matchService.checkIfMatchExists(bet.getMatchId())){
            throw new MatchNotFoundException("Mecz nie istnieje.");
        }
        if (bet.getFirstTeamResult() < 0 || bet.getSecondTeamResult() < 0){
            throw new IllegalArgumentException("Wynik nie może być ujemny");
        }

    }
}
