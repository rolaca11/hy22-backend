package com.hackyeah.hy22.bootstrap;

import com.hackyeah.hy22.models.FoodType;
import com.hackyeah.hy22.models.User;
import com.hackyeah.hy22.repositories.FoodRepository;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.FoodTypeRepository;
import com.hackyeah.hy22.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupData implements CommandLineRunner {

    private final FoodRepository foodRepository;

    private final UserRepository userRepository;

    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        FoodType milk = foodTypeRepository.save(FoodType.builder()
                .name("Milk")
                .useful(0.95f)
                .biodegradable(0.0f)
                .paper(0.05f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.0f)
                .build());

        FoodType cheese = foodTypeRepository.save(FoodType.builder()
                .name("Cheese")
                .useful(0.93f)
                .biodegradable(0.0f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.07f)
                .build());

        FoodType banana = foodTypeRepository.save(FoodType.builder()
                .name("Banana")
                .useful(0.75f)
                .biodegradable(0.25f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.0f)
                .build());

        FoodType sourCream = foodTypeRepository.save(FoodType.builder()
                .name("Sour Cream")
                .useful(0.75f)
                .biodegradable(0.25f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.05f)
                .plastic(0.1f)
                .build());

        FoodType raspberry = foodTypeRepository.save(FoodType.builder()
                .name("Raspberry")
                .useful(0.85f)
                .biodegradable(0.1f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.05f)
                .plastic(0.0f)
                .build());

        FoodType crack = foodTypeRepository.save(FoodType.builder()
                .name("Crack")
                .useful(0.65f)
                .biodegradable(0.25f)
                .paper(0.1f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.0f)
                .build());

        FoodType chicken = foodTypeRepository.save(FoodType.builder()
                .name("Chicken")
                .useful(0.7f)
                .biodegradable(0.2f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.1f)
                .build());

        FoodType fish = foodTypeRepository.save(FoodType.builder()
                .name("Fish")
                .useful(0.7f)
                .biodegradable(0.2f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.1f)
                .build());

        FoodType bread = foodTypeRepository.save(FoodType.builder()
                .name("Bread")
                .useful(0.7f)
                .biodegradable(0.2f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.1f)
                .build());

        FoodType butter = foodTypeRepository.save(FoodType.builder()
                .name("Butter")
                .useful(0.7f)
                .biodegradable(0.2f)
                .paper(0.0f)
                .communal(0.0f)
                .metal(0.0f)
                .plastic(0.1f)
                .build());

        userRepository.save(User.builder().username("ropi").password("ropi").id(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(milk)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(7))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(cheese)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(4))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(banana)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(9))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(sourCream)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(12))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(raspberry)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(8))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(crack)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(100))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(chicken)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(10))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(fish)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(4))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(bread)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(3))
                .userId(1L).build());
        foodRepository.save(FoodProduct.builder().foodType(butter)
                .insertDate(ZonedDateTime.now())
                .expirationDate(ZonedDateTime.now().plusDays(30))
                .userId(1L).build());
    }
}
