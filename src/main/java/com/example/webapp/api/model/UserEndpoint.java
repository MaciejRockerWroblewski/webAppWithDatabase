package com.example.webapp.api.model;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserEndpoint<UserService> {

    private final UserService userService;

    @PostMapping("/search")
    public List<User> getBySearchParams(@RequestBody UserSearchParams searchParams) {
        return userService.searchByParams(searchParams);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

    @PutMapping
    public void update(@Valid @RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id) {
        userService.delete(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
}
