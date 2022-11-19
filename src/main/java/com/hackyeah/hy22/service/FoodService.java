package com.hackyeah.hy22.service;

import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    public void createFood() {
        FoodProduct foodProduct = FoodProduct.builder()
                .productName("Alma")
                .build();
        foodRepository.save(foodProduct);
    }

    public void deleteFood(Long id) {
        //Todo: Handle not found case
        foodRepository.delete(foodRepository.findById(id).get());
    }
    public List<FoodProduct> listAllFood() {

        return foodRepository.findAll();
    }
}
