package com.hackyeah.hy22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private InMemoryUserDetailsManager manager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        manager.createUser(User.builder().username(username).password(passwordEncoder
                .encode(password)).authorities("authority").build());
    }
}
