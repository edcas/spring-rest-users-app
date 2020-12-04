package com.eduardnow.acl.controllers.users;

import com.eduardnow.acl.entitites.User;
import com.eduardnow.acl.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserGetController {

    private final UserService userService;

    @Autowired
    public UserGetController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<User>> handlerAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "8") int size) {
        return new ResponseEntity<>(userService.all(page, size), HttpStatus.OK);
    }

    @GetMapping("/usernames")
    public ResponseEntity<Page<String>> handlerAllByUsernames(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(value = "size", required = false, defaultValue = "8") int size) {
        return new ResponseEntity<>(userService.allByUsernames(page, size), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "Returns a user for a given username", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The record was found"),
            @ApiResponse(code = 404, message = "The record was not found")
    })
    public ResponseEntity<User> handlerByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
