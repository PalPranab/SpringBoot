package com.example.Oauth20.SpringOauth2Demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure security settings here
        http.authorizeHttpRequests(auth -> auth// Allow access to the root endpoint without authentication
                        .anyRequest().authenticated())// Require authentication for any other request
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}
