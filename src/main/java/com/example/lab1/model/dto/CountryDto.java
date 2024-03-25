package com.example.lab1.model.dto;

import lombok.Data;

@Data
public class CountryDto {
     String continent;
     String name;

    public CountryDto(String continent, String name) {
        this.continent = continent;
        this.name = name;
    }
}
