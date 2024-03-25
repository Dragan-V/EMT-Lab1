package com.example.lab1.service.impl;

import com.example.lab1.model.Country;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }
}
