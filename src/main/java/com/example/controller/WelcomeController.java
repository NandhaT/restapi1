package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to my api";
    }
}
