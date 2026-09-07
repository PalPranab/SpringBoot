package com.learn.spring.security.SpringSecurityExample.controller;

import com.learn.spring.security.SpringSecurityExample.model.Users;
import com.learn.spring.security.SpringSecurityExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return userService.verify(user);
    }

}
