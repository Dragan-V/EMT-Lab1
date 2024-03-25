package com.example.lab1.controller;

import com.example.lab1.model.Host;
import com.example.lab1.model.dto.CountryDto;
import com.example.lab1.model.dto.HostDto;
import com.example.lab1.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/host")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/add-host")
    public ResponseEntity<Void> addCountry(@RequestBody HostDto hostDto) {
        if(hostDto == null) {
            return ResponseEntity.notFound().build();
        }
        this.hostService.create(hostDto.getName(), hostDto.getSurname(), hostDto.getCountryId());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/hosts")
    public List<Host> listAll() {
        return this.hostService.listAll();
    }

    @PostMapping("/delete-host/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        this.hostService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update-host/{id}")
    public ResponseEntity<Void> updateHost(@PathVariable Long id, @RequestBody HostDto hostDto) {
        if (id == null || hostDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.hostService.update(id, hostDto.getName(), hostDto.getSurname(), hostDto.getCountryId());
        return ResponseEntity.ok().build();
    }


}
