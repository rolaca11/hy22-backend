package com.hackyeah.hy22.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodType {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Float useful;
    private Float biodegradable;
    private Float plastic;
    private Float metal;
    private Float paper;
    private Float communal;

    @OneToMany
    private List<FoodProduct> foodProducts;
}
