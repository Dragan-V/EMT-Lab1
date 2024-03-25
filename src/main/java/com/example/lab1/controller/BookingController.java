package com.example.lab1.controller;

import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import com.example.lab1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam String name,
                                                 @RequestParam Category category,
                                                 @RequestParam Host host,
                                                 @RequestParam Integer numRooms) {
        Booking createdBooking = bookingService.create(name, category, host, numRooms);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

}

