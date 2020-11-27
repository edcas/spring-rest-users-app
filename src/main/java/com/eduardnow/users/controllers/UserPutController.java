package com.eduardnow.users.controllers;

import com.eduardnow.users.models.User;
import com.eduardnow.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserPutController {

    private final UserService userService;

    @Autowired
    public UserPutController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> handler(@PathVariable("username") String username, @RequestBody User user) {
        return userService.update(username, user)
                .map(value -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
