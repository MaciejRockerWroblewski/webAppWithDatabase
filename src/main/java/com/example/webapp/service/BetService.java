package com.example.webapp.service;

import com.example.webapp.api.model.BetDetails;
import com.example.webapp.api.model.NewBet;
import com.example.webapp.exception.MatchNotFoundException;
import com.example.webapp.repository.BetEntity;
import com.example.webapp.repository.BetRepository;
import com.example.webapp.repository.MatchEntity;
import com.example.webapp.repository.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetService {

    private final MatchService matchService;
    private final BetRepository betRepository;

    public void createBet(NewBet bet){
        validateBet(bet);

BetEntity entity = BetEntity.builder()
        .firstTeamResult(bet.getFirstTeamResult())
        .secondTeamResult(bet.getSecondTeamResult())
        .match(MatchEntity.builder().id(bet.getMatchId()).build())
        .user(UserEntity.builder().id(bet.getUserId()).build())
        .build();

    }

    public void deleteBet(Long id){
        betRepository.deleteById(id);
    }
    
    public List<BetDetails> getAllForUser(Long userId) {
        return null;
    }

    public List<BetDetails> getAllForMatch(Long matchId){
        return null;
    }

    private void validateBet(NewBet bet) {
        if (!matchService.checkIfMatchExists(bet.getMatchId())){
            throw new MatchNotFoundException("Mecz nie istnieje.");
        }
        if (bet.getFirstTeamResult() < 0 || bet.getSecondTeamResult() < 0){
            throw new IllegalArgumentException("Wynik nie może być ujemny");
        }
    }


}
