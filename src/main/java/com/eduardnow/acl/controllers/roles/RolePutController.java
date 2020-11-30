package com.eduardnow.acl.controllers.roles;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RolePutController {

    private final RoleService service;

    @Autowired
    public RolePutController(RoleService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> handler(@PathVariable("id") Integer id, @RequestBody Role role) {
        return service.update(id, role)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
