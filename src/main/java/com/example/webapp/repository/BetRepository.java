package com.example.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BetRepository extends JpaRepository<BetEntity, Long> {
    List<BetEntity> findAllByUser_Id(Long userId);

    List<BetEntity> findAllByMatch_id(Long matchId);

    List<BetEntity> findAllByMatch_idAndAndFirstTeamResultAAndSecondTeamResult(Long matchId,
                                                                               Integer firstTeamResult, Integer secondTeamResult);

    @Query("select bt from BetEntity bt inner join bt.match mat " +
            "where mat.startTime = (select min(match.startTime) from MatchEntity  match)")
    List<BetEntity> findBetsForEarliestMatch();

    @Query("select bt from BetEntity where bt.firstTeamResult <> bt.secondTeamResult")
    List<BetEntity> findAllBetsWithoutDraws();


    @Query("select bt from BetEntity bt inner join bt.match mat " +
            "where (mat.firstTeam = :team or mat.secondTeam = :team) " +
            "and (mat.startTime between :startFrom and :startTo)")
    List<BetEntity> findAllByTeamAndInTimeRange();
    @Param("team") String team,
    @Param("startFrom") LocalDateTime startFrom,
    @Param("startTo") LocalDateTime startTo
            );

}
