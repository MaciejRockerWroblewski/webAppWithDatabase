package com.example.webapp.repository;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MatchEntity {
    @Setter
    private Long id;
    private String firstTeam;
    private String secondTeam;
    private LocalDateTime startTime;

}
