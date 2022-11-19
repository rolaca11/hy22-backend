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
public class ApiStatistic {

    private String day;
    private Float useful;
    private Float biodegradable;
    private Float plastic;
    private Float metal;
    private Float paper;
    private Float communal;

    public void setDay(String day) {
        this.day = day;
    }

    public void addUseful(Float useful) {
        this.useful = this.useful + useful;
    }

    public void addBiodegradable(Float biodegradable) {
        this.biodegradable = this.biodegradable + biodegradable;
    }

    public void addPlastic(Float plastic) {
        this.plastic = this.plastic + plastic;
    }

    public void addMetal(Float metal) {
        this.metal = this.metal + metal;
    }

    public void addPaper(Float paper) {
        this.paper = this.paper + paper;
    }

    public void addCommunal(Float communal) {
        this.communal = this.communal + communal;
    }
}
