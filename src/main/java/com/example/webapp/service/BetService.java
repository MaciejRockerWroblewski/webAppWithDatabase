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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BetService {

    private final MatchService matchService;
    private final BetRepository betRepository;

    public void createBet(NewBet bet) {
        validateBet(bet);

        BetEntity entity = BetEntity.builder()
                .firstTeamResult(bet.getFirstTeamResult())
                .secondTeamResult(bet.getSecondTeamResult())
                .match(MatchEntity.builder().id(bet.getMatchId()).build())
                .user(UserEntity.builder().id(bet.getUserId()).build())
                .build();

    }

    public void deleteBet(Long id) {
        betRepository.deleteById(id);
    }

    public List<BetDetails> getAllForUser(Long userId) {
        return betRepository.findAllByUser_Id(userId)
                .stream()
                .map(ent -> BetDetails.builder()
                        .id(ent.getId())
                        .firstTeam(ent.getMatch().getFirstTeam())
                        .secondTeam(ent.getMatch().getSecondTeam())
                        .startTime(ent.getMatch().getStartTime())
                        .userLogin(ent.getUser().getLogin())
                        .userName(ent.getUser().getFirstName() + " " + ent.getUser().getLastName())
                        .firstTeamResult(ent.getFirstTeamResult())
                        .secondTeamResult(ent.getSecondTeamResult())
                        .build())
                .collect(Collectors.toList());
    }


    public List<BetDetails> getAllForMatch(Long matchId) {
        return betRepository.findAllByMatch_id(matchId)
                .stream()
                .map(ent -> BetDetails.builder()
                        .id(ent.getId())
                        .firstTeam(ent.getMatch().getFirstTeam())
                        .secondTeam(ent.getMatch().getSecondTeam())
                        .startTime(ent.getMatch().getStartTime())
                        .userLogin(ent.getUser().getLogin())
                        .userName(ent.getUser().getFirstName() + " " + ent.getUser().getLastName())
                        .firstTeamResult(ent.getFirstTeamResult())
                        .secondTeamResult(ent.getSecondTeamResult())
                        .build())
                .collect(Collectors.toList());
    }

    private void validateBet(NewBet bet) {
        if (!matchService.checkIfMatchExists(bet.getMatchId())) {
            throw new MatchNotFoundException("Mecz nie istnieje.");
        }
        if (bet.getFirstTeamResult() < 0 || bet.getSecondTeamResult() < 0) {
            throw new IllegalArgumentException("Wynik nie może być ujemny");
        }
    }


}
