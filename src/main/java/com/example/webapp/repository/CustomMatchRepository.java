package com.example.webapp.repository;

import com.example.webapp.api.model.MatchSearchParameter;

import java.util.List;

public interface CustomMatchRepository {

    List<MatchEntity> searchByParams(MatchSearchParameter searchParameter);
}
