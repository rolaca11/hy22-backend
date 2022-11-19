package com.hackyeah.hy22.bootstrap;

import com.hackyeah.hy22.models.User;
import com.hackyeah.hy22.repositories.FoodRepository;
import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupData implements CommandLineRunner {

    private final FoodRepository foodRepository;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        userRepository.save(User.builder().username("ropi").password("ropi").id(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Milk")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(7))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Cheese")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(4))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Banana")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(9))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Sour Cream")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(12))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Raspberry")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(8))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Crack")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(100))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Chicken")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(10))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Fish")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(4))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Bread")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(3))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().productName("Butter")
            .insertDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(30))
                .userId(1L).build());
    }
}
