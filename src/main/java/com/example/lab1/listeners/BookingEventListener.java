package com.example.lab1.listeners;

import com.example.lab1.events.BookingCreatedEvent;
import com.example.lab1.events.BookingDeletedEvent;
import com.example.lab1.events.BookingEditedEvent;
import com.example.lab1.service.BookingService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookingEventListener {
private final BookingService bookingService;

    public BookingEventListener(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @EventListener
    public void onBookingCreated(BookingCreatedEvent event) {
        this.bookingService.onBookingCreated();
    }
    @EventListener
    public void onBookingDeleted(BookingDeletedEvent event) {
        this.bookingService.onBookingDeleted();
    }
    @EventListener
    public void onBookingEdited(BookingEditedEvent event) {
        this.bookingService.onBookingEdited();
    }
}
