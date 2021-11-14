package com.example.webapp.api;

import com.example.webapp.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchEndpoint {

    private final MatchService matchService;

    @GetMapping
    public List<Match> getAll(){
        return matchService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMatch(@RequestBody Match match){
        matchService.create(match);
    }
@PutMapping
    public void updateMatch(@RequestBody Match match){
        matchService.update(match);
}
@DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatch(@RequestParam Long id) {
        matchService.delete(id);
}
}
