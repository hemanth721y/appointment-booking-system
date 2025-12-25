package com.example.appointment.Entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Slot slot;

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Slot getSlot() { return slot; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setSlot(Slot slot) { this.slot = slot; }
}
