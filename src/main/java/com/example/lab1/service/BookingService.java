package com.example.lab1.service;

import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking create( String name, Category category, Host host, Integer numRooms);
}
