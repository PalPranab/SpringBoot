package com.learn.spring.security.SpringSecurityExample.service;

import com.learn.spring.security.SpringSecurityExample.model.Users;
import com.learn.spring.security.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);// 12 is for password round or strength

    public Users register(Users user) {
        //Encode the password by using BCryptPsswordEncoder
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUserName());

        return "failure";
    }
}
