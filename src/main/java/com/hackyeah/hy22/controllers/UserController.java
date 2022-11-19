package com.hackyeah.hy22.controllers;

import com.hackyeah.hy22.api.ApiRegisterRequest;
import com.hackyeah.hy22.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody ApiRegisterRequest request) {

        userService.registerUser(request.getUsername(),request.getPassword());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}