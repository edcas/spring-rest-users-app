package com.eduardnow.acl.services;

import com.eduardnow.acl.entitites.Role;
import com.eduardnow.acl.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Role> update(Integer id, Role role) {
        Optional<Role> roleToBeUpdated = repository.findById(id);

        if (!roleToBeUpdated.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(repository.save(role));
    }

    public void delete(Integer id) {
        repository.findById(id).ifPresent(role -> repository.deleteById(role.getId()));
    }
}
