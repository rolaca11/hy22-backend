package com.hackyeah.hy22.controllers;

import com.hackyeah.hy22.models.VersionResponse;
import com.hackyeah.hy22.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/create")
    public ResponseEntity<String> create() {

        foodService.createFood();
        return new ResponseEntity<>("Food created!", HttpStatus.OK);
    }

    @GetMapping(value = "/deleted")
    public ResponseEntity<String> delete() {

        foodService.createFood();
        return new ResponseEntity<>("Food deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity<String> listAll() {

        foodService.createFood();
        return new ResponseEntity<>("Food created!", HttpStatus.OK);
    }
}
