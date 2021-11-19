package com.example.webapp.api.model;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.webapp.api.model.Error;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalErrorHandler {


    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(value = {IllegalArgumentException.class})
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Error handleIllegalArgument(IllegalArgumentException ex){
            String code = UUID.randomUUID().toString();
            LOGGER.error("Error occured " + code, ex);

            return Error.builder()
                    .code(code)
                    .message(ex.getMessage())
                    .timestamp(LocalDateTime.now().toString())
                    .build();

    }

}
