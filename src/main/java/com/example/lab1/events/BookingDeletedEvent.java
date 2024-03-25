package com.example.lab1.events;

import org.springframework.context.ApplicationEvent;

public class BookingDeletedEvent extends ApplicationEvent {
    public BookingDeletedEvent(Object source) {
        super(source);
    }
}
