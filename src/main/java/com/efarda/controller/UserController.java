package com.efarda.controller;

import com.efarda.domain.User;
import com.efarda.exception.DataNotFound;
import com.efarda.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
class UserController {

//    private final Bucket bucket;

    public UserController(UserService userService) {
        this.userService = userService;
//        Bandwidth limit = Bandwidth.classic(1, Refill.greedy(1, Duration.ofSeconds(10)));
//        this.bucket = Bucket.builder()
//                .addLimit(limit)
//                .build();
    }

    final UserService userService;

    @GetMapping("/all")
    List<User> all() {
        return userService.allUsers();
    }

    @PostMapping("/add")
    void add(@RequestBody User user) throws DataNotFound {
        log.info("Add user: {}", Thread.currentThread());
        userService.addUser(user);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestHeader("X-API-KEY") String apiKey) {
        return "Hello, World!";

//        if (bucket.tryConsume(1)) {
//            log.error("Hello, World!");
//            return "Hello, World!";
//        } else {
//            log.error("too many requests");
//            return "Too many requests - try again later.";
//        }
    }
}