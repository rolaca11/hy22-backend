package com.hackyeah.hy22.repositories;

import com.hackyeah.hy22.models.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodProduct, Long> {
}