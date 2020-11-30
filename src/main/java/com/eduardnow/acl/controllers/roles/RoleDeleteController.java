package com.eduardnow.acl.controllers.roles;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleDeleteController {

    private final RoleService service;

    @Autowired
    public RoleDeleteController(RoleService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handler(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
