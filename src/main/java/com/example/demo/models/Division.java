package com.example.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    private String president;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    // Constructors
    public Division() {}

    public Division(String name, String district, String president) {
        this.name = name;
        this.district = district;
        this.president = president;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPresident() { return president; }
    public void setPresident(String president) { this.president = president; }

    public Association getAssociation() { return association; }
    public void setAssociation(Association association) { this.association = association; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    public void addMember(Member member) {
        members.add(member);
        member.setDivision(this);
    }
}
