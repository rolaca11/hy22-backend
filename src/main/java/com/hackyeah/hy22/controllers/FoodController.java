package com.hackyeah.hy22.controllers;

import com.hackyeah.hy22.api.ApiFoodProduct;
import com.hackyeah.hy22.api.CreateFoodRequest;
import com.hackyeah.hy22.mappers.CreateFoodRequestToFoodProductMapper;
import com.hackyeah.hy22.mappers.FoodMapper;
import com.hackyeah.hy22.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private CreateFoodRequestToFoodProductMapper createFoodRequestToFoodProductMapper;

    @PostMapping
    public ResponseEntity<ApiFoodProduct> create(@RequestBody CreateFoodRequest request) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ApiFoodProduct result = foodMapper.map(foodService.createFood(createFoodRequestToFoodProductMapper.map(request)
                ,((UserDetails)principal).getUsername()));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> delete(@PathVariable Long foodId) {

        foodService.deleteFood(foodId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<ApiFoodProduct>> listAll() {

        List<ApiFoodProduct> response = foodService.listAllFood().stream().map(
                elem -> foodMapper.map(elem)).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<ApiFoodProduct> get(@PathVariable Long foodId) {

        return new ResponseEntity<>(foodMapper.map(
                foodService.getFood(foodId)), HttpStatus.OK);
    }
}
