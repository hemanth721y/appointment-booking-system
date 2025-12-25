package com.example.appointment.controller;

import com.example.appointment.Entity.Booking;
import com.example.appointment.Entity.Slot;
import com.example.appointment.Entity.User;
import com.example.appointment.Repository.BookingRepository;
import com.example.appointment.Repository.SlotRepository;
import com.example.appointment.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final SlotRepository slotRepository;

    public BookingController(BookingRepository bookingRepository,
                             UserRepository userRepository,
                             SlotRepository slotRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.slotRepository = slotRepository;
    }

    // CREATE
    @PostMapping
    public Booking createBooking(@RequestParam Long userId,
                                 @RequestParam Long slotId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        slot.setStatus("BOOKED");
        slotRepository.save(slot);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSlot(slot);

        return bookingRepository.save(booking);
    }

    // READ ALL
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id,
                                 @RequestParam Long slotId) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        booking.setSlot(slot);
        return bookingRepository.save(booking);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return "Booking cancelled successfully";
    }
}
