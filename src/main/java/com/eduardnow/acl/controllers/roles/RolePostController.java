package com.eduardnow.acl.controllers.roles;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolePostController {

    private final RoleService service;

    @Autowired
    public RolePostController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return new ResponseEntity<>(service.save(role), HttpStatus.CREATED);
    }

}
