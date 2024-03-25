package com.example.lab1.events;

import org.springframework.context.ApplicationEvent;

public class BookingCreatedEvent extends ApplicationEvent {
public BookingCreatedEvent(Object source) {
        super(source);
    }
}
