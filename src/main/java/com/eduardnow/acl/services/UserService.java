package com.eduardnow.acl.services;

import com.eduardnow.acl.entitites.User;
import com.eduardnow.acl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> all(String startWith) {
        if (startWith == null) {
            return repository.findAll();
        }

        return repository.findAll();
    }

    public Optional<User> getByUsername(String username) {
        return null;
    }

    public Optional<User> create(User user) {
        return null;
    }

    public Optional<User> update(String username, User user) {
        return null;
    }

    public void delete(String username) {

    }
}
