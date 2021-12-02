package com.example.webapp.api.model;

import com.example.webapp.api.validator.UserNameLength;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@UserNameLength(maxLength = 50, minLength = 3)
public class User {
    private Long id;
    @Email
    private String login;
    private String firstName;
    private String lastName;

    public String getRole() {
    return null;
    }
}
