package com.hackyeah.hy22.controllers;

import com.hackyeah.hy22.models.VersionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
    @GetMapping
    public VersionResponse version() {
        return VersionResponse.builder().version("1.0.0").build();
    }
}
