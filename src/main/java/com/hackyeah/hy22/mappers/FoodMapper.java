package com.hackyeah.hy22.mappers;

import com.hackyeah.hy22.api.ApiFoodProduct;
import com.hackyeah.hy22.models.FoodProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mapping(source = "source.foodType.name", target = "productName")
    ApiFoodProduct map(FoodProduct source);

    FoodProduct map(ApiFoodProduct source);
}
