package com.efarda.sample.controller;

import com.efarda.sample.dto.UserDto;
import com.efarda.sample.exception.DataNotFound;
import com.efarda.sample.service.UserService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
class UserController {

    private final Bucket bucket;

    public UserController() {
        Bandwidth limit = Bandwidth.classic(1, Refill.greedy(1, Duration.ofSeconds(10)));
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @Autowired
    UserService userService;

    @GetMapping("/all")
    List<UserDto> all() {
        return userService.allUsers();
    }

    @PostMapping("/add")
    void add(@RequestBody UserDto user) throws DataNotFound {
        userService.addUser(user);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestHeader("X-API-KEY") String apiKey) {
        if (bucket.tryConsume(1)) {
            log.error("Hello, World!");
            return "Hello, World!";
        } else {
            log.error("too many requests");
            return "Too many requests - try again later.";
        }
    }
}