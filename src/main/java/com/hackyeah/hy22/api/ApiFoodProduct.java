package com.hackyeah.hy22.api;

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
}