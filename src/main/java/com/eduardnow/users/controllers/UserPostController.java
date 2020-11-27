package com.eduardnow.users.controllers;

import com.eduardnow.users.models.User;
import com.eduardnow.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserPostController {

    private final UserService userService;

    @Autowired
    public UserPostController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> handle(@RequestBody User user) {
        return userService.create(user)
                .map(value -> new ResponseEntity<>(user, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }

}
