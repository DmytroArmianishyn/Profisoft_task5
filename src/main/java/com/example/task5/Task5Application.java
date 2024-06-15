package com.example.task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Task5Application {

    public static void main(String[] args) {
        SpringApplication.run(Task5Application.class, args);
    }
}