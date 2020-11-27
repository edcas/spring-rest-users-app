package com.eduardnow.users.services;

import com.eduardnow.users.models.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Faker faker;

    private List<User> users = new ArrayList<>();

    @Autowired
    public UserService(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {
            users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<User> all(String startWith) {
        if (startWith == null) {
            return users;
        }

        return users.stream().filter(user -> user.getUsername().startsWith(startWith)).collect(Collectors.toList());
    }

    public Optional<User> getByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public Optional<User> create(User user) {
        if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
            return Optional.empty();
        }

        users.add(user);

        return Optional.of(user);
    }

    public Optional<User> update(String username, User user) {

        Optional<User> userToBeUpdated = this.getByUsername(username);

        if (!userToBeUpdated.isPresent()) {
            return Optional.empty();
        }

        userToBeUpdated.get().setNickName(user.getNickName());
        userToBeUpdated.get().setPassword(user.getPassword());

        return userToBeUpdated;
    }

    public void delete(String username) {
        users = users.stream().filter(user -> !username.equals(user.getUsername())).collect(Collectors.toList());
    }
}
