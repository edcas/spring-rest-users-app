package com.eduardnow.acl.controllers.roles;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleGetController {

    private final RoleService service;

    @Autowired
    public RoleGetController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
