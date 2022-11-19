package com.hackyeah.hy22.models;

import java.time.ZonedDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodProduct {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private ZonedDateTime insertDate;
    private ZonedDateTime expirationDate;
    private Long userId;
}
