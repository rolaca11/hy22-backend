package com.hackyeah.hy22.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

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
    private ZonedDateTime insertDate;
    private ZonedDateTime expirationDate;
    private Float weight;

    @ManyToOne
    private FoodType foodType;
    private Long userId;
}
