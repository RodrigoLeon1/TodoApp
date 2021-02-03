package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.model.User;
import com.rodrigoleon.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/")
    public User create(@RequestBody @Valid final User newUser) {
        return userService.create(newUser);
    }

    @PutMapping("/{id}")
    public User updateById(@RequestBody @Valid final User updatedUser,
                           @PathVariable final Long id) {
        return userService.updateById(id, updatedUser);
    }

}
