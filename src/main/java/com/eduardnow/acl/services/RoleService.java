package com.eduardnow.acl.services;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role save(Role role) {
        return repository.save(role);
    }
}
