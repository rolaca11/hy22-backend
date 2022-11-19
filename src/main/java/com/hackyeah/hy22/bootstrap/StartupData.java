package com.hackyeah.hy22.bootstrap;

import java.time.ZonedDateTime;

import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.repositories.DummyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupData implements CommandLineRunner {

    private final DummyRepo dummyRepo;

    @Override
    public void run(String... args) throws Exception {
        dummyRepo.save(FoodProduct.builder().productName("Milk")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Cheese")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Banana")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Sour Cream")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Raspberry")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Crack")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Chicken")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Fish")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Bread")
            .insertDate(ZonedDateTime.now()).build());
        dummyRepo.save(FoodProduct.builder().productName("Butter")
            .insertDate(ZonedDateTime.now()).build());
    }
}
