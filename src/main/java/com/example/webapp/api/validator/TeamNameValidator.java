package com.example.webapp.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TeamNameValidator implements ConstraintValidator<TeamName, String> {

    private static final List<String> ALLOWED_TEAMS
            = Arrays.asList("Francja", "Anglia", "Polska", "Niemcy");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContextonstraintValidatorContext){
        return ALLOWED_TEAMS.contains(value);
    }
}
