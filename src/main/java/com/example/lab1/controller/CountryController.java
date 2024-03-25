package com.example.lab1.controller;

import com.example.lab1.model.Country;
import com.example.lab1.model.dto.CountryDto;
import com.example.lab1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add-country")
    public ResponseEntity<Void> addCountry(@RequestBody CountryDto countryDto) {
        if(countryDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.countryService.create(countryDto.getName(), countryDto.getContinent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.countryService.listAll();
    }
}
