package com.example.appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.appointment.Entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}