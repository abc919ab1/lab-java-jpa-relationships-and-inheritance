package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference extends Event {

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speaker> speakers = new ArrayList<>();

    public Conference() {
        super();
    }

    public Conference(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
