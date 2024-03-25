package com.example.lab1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String continent;
    private String name;


    public Country(String continent, String name) {
        this.continent = continent;
        this.name = name;
    }


    public Country() {

    }
}
