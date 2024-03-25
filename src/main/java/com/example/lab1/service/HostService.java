package com.example.lab1.service;

import com.example.lab1.model.Category;
import com.example.lab1.model.Country;
import com.example.lab1.model.Host;

import java.util.List;

public interface HostService {
    Host create(String name, String surname,Long countryId);

    Host findById(Long id);
    List<Host> listAll();
}
