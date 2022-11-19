package com.hackyeah.hy22.controllers;

import com.hackyeah.hy22.api.ApiFoodProduct;
import com.hackyeah.hy22.mappers.FoodMapper;
import com.hackyeah.hy22.models.VersionResponse;
import com.hackyeah.hy22.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodMapper foodMapper;

    @GetMapping(value = "/create")
    public ResponseEntity<String> create() {

        foodService.createFood();
        return new ResponseEntity<>("Food created!", HttpStatus.OK);
    }

    @GetMapping(value = "/{foodId}/delete")
    public ResponseEntity<String> delete(Long foodId) {

        foodService.deleteFood(foodId);
        return new ResponseEntity<>("Food deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity<List<ApiFoodProduct>> listAll() {

        foodService.createFood();
        List<ApiFoodProduct> response = foodService.listAllFood().stream().map(
                elem -> foodMapper.map(elem)).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
