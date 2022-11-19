package com.hackyeah.hy22.mappers;

import com.hackyeah.hy22.api.ApiFoodProduct;
import com.hackyeah.hy22.models.FoodProduct;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface FoodMapper {
    ApiFoodProduct map(FoodProduct source);

    FoodProduct map(ApiFoodProduct source);
}
