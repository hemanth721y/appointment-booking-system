package com.example.appointment.service;

import org.springframework.stereotype.Service;
import com.example.appointment.Entity.*;
import com.example.appointment.Repository.*;

@Service
public class BookingService {

    private final SlotRepository slotRepo;
    private final BookingRepository bookingRepo;

    public BookingService(SlotRepository slotRepo, BookingRepository bookingRepo) {
        this.slotRepo = slotRepo;
        this.bookingRepo = bookingRepo;
    }

    public String bookSlot(User user, Long slotId) {

        Slot slot = slotRepo.findById(slotId).orElse(null);

        if (slot == null) return "Slot Not Found";

        if ("BOOKED".equals(slot.getStatus())) {
            return "Slot Already Booked";
        }

        slot.setStatus("BOOKED");
        slotRepo.save(slot);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSlot(slot);
        bookingRepo.save(booking);

        return "Appointment Booked Successfully";
    }
}