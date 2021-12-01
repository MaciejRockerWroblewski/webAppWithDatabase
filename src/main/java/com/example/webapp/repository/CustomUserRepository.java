package com.example.webapp.repository;

import com.example.webapp.api.model.UserSearchParams;

import java.util.List;

public interface CustomUserRepository {
    List<UserEntity> searchByParams(UserSearchParams searchParams);


}
