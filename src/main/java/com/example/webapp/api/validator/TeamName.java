package com.example.webapp.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TeamNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TeamName {
    String message() default "Nieznana drużyna.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
