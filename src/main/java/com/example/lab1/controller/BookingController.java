package com.example.lab1.controller;

import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import com.example.lab1.model.dto.BookingDto;
import com.example.lab1.service.BookingService;
import com.example.lab1.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final HostService hostService;

    @Autowired
    public BookingController(BookingService bookingService, HostService hostService) {
        this.bookingService = bookingService;
        this.hostService = hostService;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> listAll() {
        List<Booking> bookings = bookingService.listAll();
        return ResponseEntity.ok(bookings);
    }



    @PostMapping("/add-booking")
    public ResponseEntity<Void> addBooking(@RequestBody BookingDto bookingDto) {
        if(bookingDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(bookingDto.getHost().getId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.bookingService.create(bookingDto.getName(), bookingDto.getCategory(), bookingDto.getHost(), bookingDto.getNumRooms());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete-booking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        this.bookingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/update-booking/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        if(id == null || bookingDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.bookingService.update(id, bookingDto.getName(), bookingDto.getCategory(), bookingDto.getHost(), bookingDto.getNumRooms());
        return ResponseEntity.ok().build();
    }

}

