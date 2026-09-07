package com.learn.spring.security.SpringSecurityExample.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String about() {
        return "Hello World";
    }
    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "Welcome to Spring Security" + request.getSession().getId();
    }
}
