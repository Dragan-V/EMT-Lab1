package com.example.lab1.model.dto;

import com.example.lab1.model.Country;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class HostDto {
    String name;
    String surname;
    Long countryId;
}
