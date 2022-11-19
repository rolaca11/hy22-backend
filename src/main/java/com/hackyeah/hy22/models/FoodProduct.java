package com.hackyeah.hy22.models;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodProduct {
    private String productName;
    private ZonedDateTime insertDate;
}
