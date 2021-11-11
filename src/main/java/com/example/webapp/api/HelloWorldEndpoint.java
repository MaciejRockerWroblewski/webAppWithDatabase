package com.example.webapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldEndpoint {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HelloWorldEndpoint.class);

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World from first controller";
    }

    @GetMapping("/name")
    public String helloWorldWithName(@RequestParam String firstName) {
        return "Hello World " + firstName;

    }

    @GetMapping("/greetings/{lang}")
    public String helloWorldInOtherLanguages(@PathVariable("lang") String language) {
        switch (language.toLowerCase()) {
            case "en":
                return "Hello World!";
            case "de":
                return "Halo Welt!";
            case "pl":
                return "Witaj Swiecie!";
            default:
                return "Unknown language";
        }
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        LOGGER.info("FirstName: " + user.getFirstName());
        LOGGER.info("LastName: " + user.getLastName());
        LOGGER.info("Email: " + user.getEmail());

    }
}
