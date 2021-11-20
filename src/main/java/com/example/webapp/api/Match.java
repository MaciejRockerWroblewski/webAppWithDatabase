package com.example.webapp.api;

import com.example.webapp.api.validator.DifferentTeams;
import com.example.webapp.api.validator.TeamName;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DifferentTeams
public class Match {
    private Long id;
    @TeamName
    @NotBlank(message = "Nazwa zespołu nie może być pusta.")
    private String firstTeam;
    @NotBlank(message = "Nazwa zespołu ni może być pusta.")
    private String secondTeam;
    @Future(message = "Data rozegrania meczu nie może być z przeszłości. ")
    private LocalDateTime startTime;

}
