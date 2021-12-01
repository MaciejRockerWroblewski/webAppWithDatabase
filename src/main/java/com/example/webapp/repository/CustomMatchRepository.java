package com.example.webapp.repository;

import com.example.webapp.api.Match;
import com.example.webapp.api.model.MatchSearchParameter;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CustomMatchRepository {

    List<Match> searchByParams(MatchSearchParameter searchParameter);
}
