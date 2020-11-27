package com.eduardnow.users.services;

import com.eduardnow.users.models.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<User> all() {
        return users;
    }

    public Optional<User> getByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

}
