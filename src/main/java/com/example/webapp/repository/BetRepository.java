package com.example.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<BetEntity, Long> {
List<BetEntity> findAllByUser_Id(Long userId);

List<BetEntity> findAllByMatch_id(Long matchId);




}
