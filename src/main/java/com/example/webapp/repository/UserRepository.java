package com.example.webapp.repository;

import com.example.webapp.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {
    Optional<UserEntity> findByLogin(String username);
    List<UserEntity> findAllByLoginEndsWith(String loginSuffix);
    List<UserEntity> findAllByFirstNameIgnoreCase(String firstName);

    @Query("select distinct us from UserEntity us inner join us.bets bt where bt.firstTeamResult = bt.secondTeamResult")
    List<UserEntity> findAllUsersWithDrawBet();

    @Query("select us from UserEntity us inner join us.bets bt " +
    "where bt.firstTeamResult > :minGoals or bt.secondTeamResult > :minGoals")
    List<UserEntity> findAllUsersWithBetsWithMinNumberOfGoals(@Param("minGoals") Integer minGoals);

    @Query("select distinct us from UserEntity us inner join us.bets bt where" +
            "(bt.firstTeamResult + bt.secondTeamResult) = " +
            "(select max (bet.firstTeamResult + bet.secondTeamResult) from BetEntity bet)")
    List<UserEntity> findAllUsersWithBetsWithHighestNumberOfGoals();

    @Query("select distinct us.login from UserEntity us inner join us.bets ")
    List<String> findLoginsOfUsersWithBets();

}
