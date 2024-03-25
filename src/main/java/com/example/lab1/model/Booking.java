package com.example.lab1.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToOne
    private Host host;
    private Integer numRooms;

    public Booking(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }


    public Booking() {

    }
}
