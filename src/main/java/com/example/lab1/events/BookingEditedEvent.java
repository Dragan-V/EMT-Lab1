package com.example.lab1.events;

import org.springframework.context.ApplicationEvent;

public class BookingEditedEvent extends ApplicationEvent {
    public BookingEditedEvent(Object source) {
        super(source);
    }
}
