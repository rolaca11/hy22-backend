package com.hackyeah.hy22.repositories;

import com.hackyeah.hy22.models.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodProduct, Long> {
    List<FoodProduct> findAllByUserId(Long userId);
}
