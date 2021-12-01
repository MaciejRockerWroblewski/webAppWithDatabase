package com.example.webapp.service;

import com.example.webapp.api.Match;
import com.example.webapp.api.model.MatchSearchParameter;
import com.example.webapp.exception.DateInPastException;
import com.example.webapp.exception.MatchNotFoundException;
import com.example.webapp.repository.MatchEntity;
import com.example.webapp.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository repository;

    public List<Match> getBySearchParameter(MatchSearchParameter searchParameter) {
        return repository.searchByParams(searchParameter)
                .stream()
                .map((Match ent) -> toMatch(MatchEntity.builder().build()))
                .collect(Collectors.toList());
    }

    public boolean checkIfMatchExists(Long id) {
        return repository.existsById(id);
    }

    public void create(Match match) {
        if (match.getFirstTeam().isEmpty() || match.getSecondTeam().isEmpty()) {
            throw new IllegalStateException("Nie podano zespolow bioracyh udzial w meczu");
        }

        if (LocalDateTime.now().isAfter(match.getStartTime())) {
            //throw new DateInPastException("Godzina meczu jest z przeszlosci");
        }

        repository.save(MatchEntity.builder()
                .firstTeam(match.getFirstTeam())
                .secondTeam(match.getSecondTeam())
                .startTime(match.getStartTime())
                .build());
    }

    public void update(Match match) {
        if (LocalDateTime.now().isAfter(match.getStartTime())) {
            throw new DateInPastException("Godzina meczu jest z przeszlosci");
        }

        if (!repository.existsById(match.getId())) {
            throw new MatchNotFoundException("Mecz nie istnieje");
        }

        repository.save(MatchEntity.builder()
                .id(match.getId())
                .firstTeam(match.getFirstTeam())
                .secondTeam(match.getSecondTeam())
                .startTime(match.getStartTime())
                .build());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new MatchNotFoundException("Mecz nie istnieje");
        }

        repository.deleteById(id);
    }

    public List<Match> getAll() {
        return repository.findAll().stream()
                .map(this::toMatch)
                .collect(Collectors.toList());
    }

    public Match getById(Long id) {
        return toMatch(repository.getById(id));
    }

    private Match toMatch(MatchEntity ent) {
        return Match.builder()
                .id(ent.getId())
                .firstTeam(ent.getFirstTeam())
                .secondTeam(ent.getSecondTeam())
                .startTime(ent.getStartTime())
                .build();
    }

}

