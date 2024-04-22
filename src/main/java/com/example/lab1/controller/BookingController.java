package com.example.lab1.controller;

import com.example.lab1.events.BookingCreatedEvent;
import com.example.lab1.events.BookingDeletedEvent;
import com.example.lab1.events.BookingEditedEvent;
import com.example.lab1.model.Booking;
import com.example.lab1.model.Category;
import com.example.lab1.model.Host;
import com.example.lab1.model.dto.BookingDto;
import com.example.lab1.service.BookingService;
import com.example.lab1.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final HostService hostService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public BookingController(BookingService bookingService, HostService hostService, ApplicationEventPublisher applicationEventPublisher) {
        this.bookingService = bookingService;
        this.hostService = hostService;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> listAll() {
        List<Booking> bookings = bookingService.listAll();

        return ResponseEntity.ok(bookings);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/categories")
    public ResponseEntity<Category[]> getCategories() {
        return ResponseEntity.ok(Category.values());
    }

    @PostMapping("/add-booking")
    public ResponseEntity<Void> addBooking(@RequestBody BookingDto bookingDto) {
        if(bookingDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(bookingDto.getHost().getId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.applicationEventPublisher.publishEvent(new BookingCreatedEvent(this.bookingService.create(bookingDto.getName(), bookingDto.getCategory(), bookingDto.getHost(), bookingDto.getNumRooms())));
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/delete-booking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }
        this.applicationEventPublisher.publishEvent(new BookingDeletedEvent(id));
        this.bookingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/update-booking/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        if(id == null || bookingDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.bookingService.update(id, bookingDto.getName(), bookingDto.getCategory(), bookingDto.getHost(), bookingDto.getNumRooms());
        this.applicationEventPublisher.publishEvent(new BookingEditedEvent(id));
        return ResponseEntity.ok().build();
    }
    @PostMapping("/rent/{id}")
    public ResponseEntity<Void> rentRoom(@PathVariable Long id){
        this.bookingService.rent(id);
        return ResponseEntity.ok().build();
    }

}

//{
//        "name": "United States",
//        "continent": "North America"
//        }
//
//        {
//        "name":"Petar",
//        "surname":"Petrovski",
//        "countryId":"1"
//        }
//
//        {
//        "name": "Booking Name",
//        "category": "ROOM",
//        "host": {
//        "id": 1
//        },
//        "numRooms": 3
//        }