package com.example.lab1.service.impl;

import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import com.example.lab1.model.exceptions.BookingNotFoundException;
import com.example.lab1.repository.BookingsRepository;
import com.example.lab1.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingsRepository bookingsRepository;

    public BookingServiceImpl(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @Override
    public List<Booking> listAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingsRepository.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public Booking create(String name, Category category, Host host, Integer numRooms) {
        Booking newBooking = new Booking(name,category,host,numRooms);
        return bookingsRepository.save(newBooking);
    }
}
