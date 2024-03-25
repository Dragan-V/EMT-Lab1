package com.example.lab1.service;

import com.example.lab1.model.Country;

import java.util.List;

public interface CountryService {
    Country create(String name,String continent);

    List<Country> listAll();

    Country findById(Long id);

    void deleteById(Long id);

    Country update(Long id, String name, String continent);
}
