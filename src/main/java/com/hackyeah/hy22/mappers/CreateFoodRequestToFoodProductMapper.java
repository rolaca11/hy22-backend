package com.hackyeah.hy22.mappers;

import com.hackyeah.hy22.api.CreateFoodRequest;
import com.hackyeah.hy22.models.FoodProduct;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CreateFoodRequestToFoodProductMapper {
    public FoodProduct map(CreateFoodRequest request) {
        return FoodProduct.builder()
                .productName(request.getProductName())
                .expirationDate(request.getExpirationDate())
                .insertDate(ZonedDateTime.now())
                .build();
    }
}
