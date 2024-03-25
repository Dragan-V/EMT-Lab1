package com.example.lab1.repository;

import com.example.lab1.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingsRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAll();
}
