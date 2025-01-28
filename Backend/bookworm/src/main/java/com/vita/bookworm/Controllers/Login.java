package com.vita.bookworm.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
