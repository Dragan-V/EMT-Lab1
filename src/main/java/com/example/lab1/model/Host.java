package com.example.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Host {
    @Id
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Host() {

    }
}
