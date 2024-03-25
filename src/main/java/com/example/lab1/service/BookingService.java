package com.example.lab1.service;

import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    List<Booking> listAll();

    Booking findById(Long id);

    Booking create( String name, Category category, Host host, Integer numRooms);

    void deleteById(Long id);

    Booking update(Long id, String name, Category category, Host host, Integer numRooms);
}
