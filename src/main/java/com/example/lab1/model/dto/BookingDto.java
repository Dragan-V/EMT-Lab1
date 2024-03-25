package com.example.lab1.model.dto;

import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import jakarta.persistence.*;
import lombok.Data;





@Data
public class BookingDto {
    private String name;
    private Category category;
    private Host host;
    private Integer numRooms;

    public BookingDto(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }


    public BookingDto() {

    }
}
