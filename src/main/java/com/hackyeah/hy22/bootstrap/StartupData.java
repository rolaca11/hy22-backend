package com.hackyeah.hy22.bootstrap;

import com.hackyeah.hy22.repositories.FoodRepository;
import java.time.ZonedDateTime;

import com.hackyeah.hy22.models.FoodProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupData implements CommandLineRunner {

    private final FoodRepository foodRepository;

    @Override
    public void run(String... args) throws Exception {
        foodRepository.save(FoodProduct.builder().productName("Milk")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(7)).build());
        foodRepository.save(FoodProduct.builder().productName("Cheese")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(4)).build());
        foodRepository.save(FoodProduct.builder().productName("Banana")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(9)).build());
        foodRepository.save(FoodProduct.builder().productName("Sour Cream")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(12)).build());
        foodRepository.save(FoodProduct.builder().productName("Raspberry")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(8)).build());
        foodRepository.save(FoodProduct.builder().productName("Crack")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(100)).build());
        foodRepository.save(FoodProduct.builder().productName("Chicken")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(10)).build());
        foodRepository.save(FoodProduct.builder().productName("Fish")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(4)).build());
        foodRepository.save(FoodProduct.builder().productName("Bread")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(3)).build());
        foodRepository.save(FoodProduct.builder().productName("Butter")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(30)).build());
    }
}
