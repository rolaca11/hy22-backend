package com.hackyeah.hy22.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {
    private String productName;
    private Float weight;
    private ZonedDateTime expirationDate;
}