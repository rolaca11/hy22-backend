package com.hackyeah.hy22.service;

import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void createFood(FoodProduct foodProduct) {
        foodRepository.save(foodProduct);
    }

    public void deleteFood(Long id) {
        //Todo: Handle not found case
        foodRepository.delete(foodRepository.findById(id).get());
    }

    public List<FoodProduct> listAllFood() {
        return foodRepository.findAll();
    }

    public FoodProduct getFood(Long id) {
        //Todo: Handle not found case
        return foodRepository.findById(id).get();
    }
}
