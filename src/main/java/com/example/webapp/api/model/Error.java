package com.example.webapp.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Error {

    private String message;
    private String timestamp;
    private String code;

}
