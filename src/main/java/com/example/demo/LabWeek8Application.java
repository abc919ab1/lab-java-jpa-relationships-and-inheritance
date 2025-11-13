package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LabWeek8Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek8Application.class, args);
    }

    // Step 1: Public Relations Contacts
    @Bean
    CommandLineRunner step1Runner(ContactRepository contactRepository) {
        return args -> {
            Contact c1 = new Contact("Acme Corp", "PR Manager",
                    new Name("Mr.", "John", "A.", "Doe"));
            Contact c2 = new Contact("Beta Inc", "Director",
                    new Name("Ms.", "Jane", "", "Smith"));
            Contact c3 = new Contact("Gamma LLC", "Coordinator",
                    new Name("Dr.", "Alice", "B.", "Johnson"));

            contactRepository.save(c1);
            contactRepository.save(c2);
            contactRepository.save(c3);

            System.out.println("Step 1: Sample contacts saved!");
        };
    }

    // Step 2: Nurse Association with Divisions and Members
    @Bean
    CommandLineRunner step2Runner(
            AssociationRepository associationRepository
    ) {
        return args -> {
            // 1. Create an Association
            Association association = new Association("Nurse Association of Spain");

            // 2. Create 7 Divisions with 1 Member each
            List<Division> divisions = new ArrayList<>();
            for (int i = 1; i <= 7; i++) {
                Division division = new Division("Division " + i, "District " + i);

                Member member = new Member(
                        "Member " + i,
                        Status.ACTIVE,
                        LocalDate.now().plusDays(i * 30)
                );

                member.setDivision(division);
                division.setPresident(member);
                division.getMembers().add(member);

                division.setAssociation(association);
                divisions.add(division);
            }

            // Add divisions to association
            association.setDivisions(divisions);

            // Save association (cascades to divisions and members)
            associationRepository.save(association);

            System.out.println("Step 2: Association, Divisions, and Members saved!");
        };
    }
}
