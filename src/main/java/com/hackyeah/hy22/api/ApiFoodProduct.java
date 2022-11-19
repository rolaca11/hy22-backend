package com.hackyeah.hy22.api;

import com.hackyeah.hy22.models.FoodType;
import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiFoodProduct {
    private Long id;
    private String productName;
    private ZonedDateTime insertDate;
    private ZonedDateTime expirationDate;
    private Long userId;
    private FoodType foodType;
}
