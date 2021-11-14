package com.example.webapp.api;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
private Long id;
private String firstTeam;
private String secondTeam;
private LocalDateTime startTime;

}
