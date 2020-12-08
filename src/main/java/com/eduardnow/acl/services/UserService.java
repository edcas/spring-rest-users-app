package com.eduardnow.acl.services;

import com.eduardnow.acl.entitites.User;
import com.eduardnow.acl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "users", unless = "#result == null")
    public Page<User> all(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Page<String> allByUsernames(int page, int size) {
        return repository.findAllUsernames(PageRequest.of(page, size));
    }

    @Cacheable(value = "usernames", key = "#username", unless = "#result == null")
    public Optional<User> getByUsername(String username) {
        return repository.findByUsername(username);
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
