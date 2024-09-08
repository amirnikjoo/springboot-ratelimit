package com.efarda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class eFardaApplication {

    public static void main(String[] args) {
        SpringApplication.run(eFardaApplication.class, args);
    }

}
