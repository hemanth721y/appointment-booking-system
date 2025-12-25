package com.example.appointment.Entity;

import jakarta.persistence.*;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotDate;
    private String slotTime;
    private String status;

    public Long getId() { return id; }
    public String getSlotDate() { return slotDate; }
    public String getSlotTime() { return slotTime; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setSlotDate(String slotDate) { this.slotDate = slotDate; }
    public void setSlotTime(String slotTime) { this.slotTime = slotTime; }
    public void setStatus(String status) { this.status = status; }
}