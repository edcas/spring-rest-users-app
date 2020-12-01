package com.eduardnow.acl.controllers.users;

import com.eduardnow.acl.entitites.User;
import com.eduardnow.acl.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<User>> handlerAll(@RequestParam(value = "startWith", required = false) String startWith) {
        return new ResponseEntity<>(userService.all(startWith), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> handlerByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
