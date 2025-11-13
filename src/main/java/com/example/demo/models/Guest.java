package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    // getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public GuestStatus getStatus() { return status; }
    public void setStatus(GuestStatus status) { this.status = status; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
