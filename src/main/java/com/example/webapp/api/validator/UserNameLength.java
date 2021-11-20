package com.example.webapp.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserNameLengthValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNameLength {

    String message() default "Imię i nazwisko nie mogą być dłuższe niż 50 znaków.";
    int minLength() default 0;
    int maxLength() default 50;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
