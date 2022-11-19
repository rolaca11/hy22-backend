package com.hackyeah.hy22.service;

import com.hackyeah.hy22.exception.NoSuchElementFoundException;
import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.models.User;
import com.hackyeah.hy22.repositories.FoodRepository;
import com.hackyeah.hy22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    public FoodProduct createFood(FoodProduct foodProduct, String username) {
        User user = userRepository.findByUsername(username);
        foodProduct.setUserId(user.getId());
        return foodRepository.save(foodProduct);
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
