package com.example.lab1.service.impl;

import com.example.lab1.model.Country;
import com.example.lab1.model.Host;
import com.example.lab1.model.exceptions.HostNotFoundException;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.repository.HostRepository;
import com.example.lab1.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Host findById(Long id) {
        return this.hostRepository.findById(id).orElseThrow(HostNotFoundException::new);
    }
    @Override
    public List<Host> listAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Host create(String name, String surname, Long country) {
        return this.hostRepository.save(new Host(name, surname, this.countryRepository.findById(country).get()));
    }
}
