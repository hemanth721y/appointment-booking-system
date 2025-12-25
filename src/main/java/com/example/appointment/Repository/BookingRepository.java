package com.example.appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.appointment.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
