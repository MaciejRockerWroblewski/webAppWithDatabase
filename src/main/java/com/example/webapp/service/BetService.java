package com.example.webapp.service;

import com.example.webapp.api.model.Bet;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    public void createBet(Bet bet){
        if (bet.getFirstTeamResult() < 0 || bet.getSecondTeamResult() < 0){
            throw new IllegalArgumentException("Wynik nie może być ujemny");
        }

    }
}
