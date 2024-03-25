package com.example.lab1.model.dto;

import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookingDto {
     String name;
     Category category;
     Host host;
     Integer numRooms;
}
