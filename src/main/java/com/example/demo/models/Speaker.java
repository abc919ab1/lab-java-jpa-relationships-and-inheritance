package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer presentationDuration;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    // getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getPresentationDuration() { return presentationDuration; }
    public void setPresentationDuration(Integer presentationDuration) { this.presentationDuration = presentationDuration; }
    public Conference getConference() { return conference; }
    public void setConference(Conference conference) { this.conference = conference; }
}
