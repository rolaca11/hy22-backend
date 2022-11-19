package com.hackyeah.hy22.service;

import com.hackyeah.hy22.exception.NoSuchElementFoundException;
import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void createFood(FoodProduct foodProduct) {
        foodRepository.save(foodProduct);
    }

    public void deleteFood(Long id) {
        foodRepository.delete(getFoodProductSafely(id));
    }

    public List<FoodProduct> listAllFood() {
        return foodRepository.findAll();
    }

    public FoodProduct getFood(Long id) {
        return getFoodProductSafely(id);
    }

    private FoodProduct getFoodProductSafely(Long id) {
        Optional<FoodProduct> foodProduct = foodRepository.findById(id);
        if(foodProduct.isEmpty()){
            throw new NoSuchElementFoundException(String.format("Invalid food id. Id=%s",id));
        }
        return foodProduct.get();
    }
}
