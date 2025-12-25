package com.example.appointment.controller;

import com.example.appointment.Entity.Slot;
import com.example.appointment.Repository.SlotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {

    private final SlotRepository slotRepository;

    public SlotController(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    // CREATE
    @PostMapping
    public Slot createSlot(@RequestBody Slot slot) {
        slot.setStatus("AVAILABLE");
        return slotRepository.save(slot);
    }

    // READ ALL
    @GetMapping
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Slot getSlot(@PathVariable Long id) {
        return slotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Slot updateSlot(@PathVariable Long id, @RequestBody Slot slot) {
        Slot existing = slotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        existing.setSlotDate(slot.getSlotDate());
        existing.setSlotTime(slot.getSlotTime());
        existing.setStatus(slot.getStatus());
        return slotRepository.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Long id) {
        slotRepository.deleteById(id);
        return "Slot deleted successfully";
    }
}
