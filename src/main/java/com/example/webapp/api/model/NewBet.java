package com.example.webapp.api.model;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.security.MessageDigest;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NewBet {

    private Long id;
    @NotNull(message = "Nie podano meczu")
    private Long matchId;

    private Integer firstTeamResult;
    private Integer secondTeamResult;

    @AssertTrue(message = "Wynik musi być poprawny.")
    public boolean isCorrectResult(){
        return firstTeamResult >=0 && firstTeamResult < 100 && secondTeamResult >=0 && secondTeamResult <0;

    }
}
