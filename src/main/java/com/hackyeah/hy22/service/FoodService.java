package com.hackyeah.hy22.service;

import com.hackyeah.hy22.api.ApiStatistic;
import com.hackyeah.hy22.exception.NoSuchElementFoundException;
import com.hackyeah.hy22.models.FoodProduct;
import com.hackyeah.hy22.models.User;
import com.hackyeah.hy22.repositories.FoodRepository;
import com.hackyeah.hy22.repositories.UserRepository;
import jdk.jshell.JShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private UserRepository userRepository;
    public FoodProduct createFood(FoodProduct foodProduct, String username) {
        User user = userRepository.findByUsername(username);
        foodProduct.setUserId(user.getId());
        return foodRepository.save(foodProduct);
    }

    public void deleteFood(Long id) {
        foodRepository.delete(getFoodProductSafely(id));
    }

    public List<FoodProduct> listAllFood() {
        return foodRepository.findAll();
    }

    public FoodProduct getFood(Long id) {
        return getFoodProductSafely(id);
    }

    private FoodProduct getFoodProductSafely(Long id) {
        Optional<FoodProduct> foodProduct = foodRepository.findById(id);
        if (foodProduct.isEmpty()) {
            throw new NoSuchElementFoundException(String.format("Invalid food id. Id=%s", id));
        }
        return foodProduct.get();
    }

    public List<ApiStatistic> getMonthlyStatistic(String username) {
        List<ApiStatistic> apiStatistics = new ArrayList<>();
        for (long i = 0; i <= 30; i++) {
            apiStatistics.add(getDailyStatistic(username, ZonedDateTime.now().minusDays(i)));
        }
        return apiStatistics;
    }

    public ApiStatistic getDailyStatistic(String username, ZonedDateTime time) {
        User user = userRepository.findByUsername(username);
        List<FoodProduct> foodProducts = foodRepository.findAllByUserId(user.getId());

        List<FoodProduct> dailyFoodProducts = foodProducts.stream().filter(elem -> elem.getExpirationDate().getDayOfMonth() == time.getDayOfMonth())
                .collect(Collectors.toList());

        ApiStatistic apiStatistic = ApiStatistic.builder()
                .biodegradable(0F)
                .communal(0F)
                .useful(0F)
                .metal(0F)
                .paper(0F)
                .plastic(0F)
                .build();

        dailyFoodProducts.forEach(
                elem -> addToApiStatistic(elem, apiStatistic)
        );
        apiStatistic.setDay(time.toString());
        return apiStatistic;
    }

    private void addToApiStatistic(FoodProduct elem, ApiStatistic apiStatistic) {
        apiStatistic.addMetal(elem.getFoodType().getMetal() * elem.getWeight());
        apiStatistic.addBiodegradable(elem.getFoodType().getBiodegradable() * elem.getWeight());
        apiStatistic.addCommunal(elem.getFoodType().getCommunal() * elem.getWeight());
        apiStatistic.addPlastic(elem.getFoodType().getPlastic() * elem.getWeight());
        apiStatistic.addPaper(elem.getFoodType().getPaper() * elem.getWeight());
        apiStatistic.addUseful(elem.getFoodType().getUseful() * elem.getWeight());
    }
}
