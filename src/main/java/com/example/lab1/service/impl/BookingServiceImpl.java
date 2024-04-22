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

    @Override
    public void rent(Long id) {
        Booking booking = bookingsRepository.findById(id).orElseThrow();
        booking.setNumRooms(booking.getNumRooms()-1);
        bookingsRepository.save(booking);
        if(booking.getNumRooms()==0){
            this.bookingsRepository.deleteById(id);
        }

    }

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

    @Override
    public void deleteById(Long id) {
        var booking = this.findById(id);
        bookingsRepository.delete(booking);
    }

    @Override
    public Booking update(Long id,String name,Category category,Host host,Integer numRooms){
        var booking = this.findById(id);
        booking.setName(name);
        booking.setCategory(category);
        booking.setHost(host);
        booking.setNumRooms(numRooms);
        return bookingsRepository.save(booking);
    }
    @Override
    public void onBookingCreated(){
        System.out.println("[CREATE]: Booking created successfully");
    }
    @Override
    public void onBookingEdited(){
        System.out.println("[EDIT]: Booking edited successfully");
    }
    @Override
    public void onBookingDeleted(){
        System.out.println("[DELETE]: Booking deleted successfully");
    }
}
