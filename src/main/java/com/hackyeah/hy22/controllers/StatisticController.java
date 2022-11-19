package com.hackyeah.hy22.controllers;


import com.hackyeah.hy22.api.ApiStatistic;
import com.hackyeah.hy22.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private FoodService foodService;


    @GetMapping
    public ResponseEntity<List<ApiStatistic>> getStatistic() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ApiStatistic> result = foodService.getMonthlyStatistic(((UserDetails)principal).getUsername());
        return ResponseEntity.ok((result));
    }
}
