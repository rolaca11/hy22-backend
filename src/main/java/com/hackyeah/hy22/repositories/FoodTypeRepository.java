package com.hackyeah.hy22.repositories;

import com.hackyeah.hy22.models.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    Optional<FoodType> findByName(String name);
}
