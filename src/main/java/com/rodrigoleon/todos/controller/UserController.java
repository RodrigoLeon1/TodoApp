package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.exception.user.UserDoesNotExistException;
import com.rodrigoleon.todos.model.User;
import com.rodrigoleon.todos.service.UserService;
import com.rodrigoleon.todos.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody @Valid final User newUser) {
        User user = userService.create(newUser);
        return ResponseEntity.created(RestUtils.getLocation(user.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@RequestBody @Valid final User updatedUser,
                                           @PathVariable final Long id) throws UserDoesNotExistException {
        User user = userService.updateById(id, updatedUser);
        return ResponseEntity.ok(user);
    }

}
