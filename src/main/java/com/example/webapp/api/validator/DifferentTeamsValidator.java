package com.example.webapp.api.validator;


import com.example.webapp.api.Match;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DifferentTeamsValidator implements ConstraintValidator<DifferentTeams, Match> {
    @Override
    public boolean isValid(Match match, ConstraintValidatorContext constraintValidatorContext) {
        return match.getFirstTeam()
                .equalsIgnoreCase(match.getSecondTeam());
    }
}
