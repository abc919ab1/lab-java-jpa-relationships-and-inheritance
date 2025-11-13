package com.example.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    private List<Division> divisions = new ArrayList<>();

    // Constructors
    public Association() {}

    public Association(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Division> getDivisions() { return divisions; }
    public void setDivisions(List<Division> divisions) { this.divisions = divisions; }

    public void addDivision(Division division) {
        divisions.add(division);
        division.setAssociation(this);
    }
}
