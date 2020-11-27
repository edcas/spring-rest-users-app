package com.eduardnow.users.controllers;

import com.eduardnow.users.models.User;
import com.eduardnow.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserGetController {

    private final UserService userService;

    @Autowired
    public UserGetController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> handlerAll() {
        return new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> handlerByUsername(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
