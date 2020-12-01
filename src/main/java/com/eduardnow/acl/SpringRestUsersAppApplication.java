package com.eduardnow.acl;

import com.eduardnow.acl.entitites.User;
import com.eduardnow.acl.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestUsersAppApplication implements ApplicationRunner {

    private final Faker faker;

    private final UserRepository userRepository;

    @Autowired
    public SpringRestUsersAppApplication(Faker faker, UserRepository userRepository) {
        this.faker = faker;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestUsersAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 100; i++) {
            userRepository.save(new User(faker.name().username(), faker.dragonBall().character(), null));
        }
    }
}
