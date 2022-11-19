package com.hackyeah.hy22.service;

import com.hackyeah.hy22.models.User;
import com.hackyeah.hy22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(String username, String password) {
        userRepository.save(User.builder().username(username).password(password).build());
    }
}
