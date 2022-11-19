package com.hackyeah.hy22.mappers;

import com.hackyeah.hy22.api.CreateFoodRequest;
import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
@Component
@RequiredArgsConstructor
public class CreateFoodRequestToFoodProductMapper {

    private final FoodTypeRepository foodTypeRepository;

    public FoodProduct map(CreateFoodRequest request) {
        return FoodProduct.builder()
                .foodType(foodTypeRepository.findByName(request.getProductName()).orElseThrow())
                .expirationDate(request.getExpirationDate())
                .insertDate(ZonedDateTime.now())
                .build();
    }
}
