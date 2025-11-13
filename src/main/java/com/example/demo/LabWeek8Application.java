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

    // ================= Step 1: Public Relations Contact System =================
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

    // ================= Step 2: Nurse Association Division Management =================
    @Bean
    CommandLineRunner step2Runner(
            AssociationRepository associationRepository
    ) {
        return args -> {
            // 1. Create an Association
            Association association = new Association("Nurse Association of Spain");

            // 2. Create 7 Divisions
            for (int i = 1; i <= 7; i++) {
                Division division = new Division("Division " + i, "District " + i, null);

                // 3. Create at least 1 Member per Division
                Member member = new Member(
                        "Member " + i,
                        Status.ACTIVE,
                        LocalDate.now().plusDays(i * 30)
                );

                // Link member to division
                division.addMember(member);

                // Link division to association
                association.addDivision(division);
            }

            // 4. Save association (cascades all divisions and members)
            associationRepository.save(association);

            System.out.println("Step 2: Association, Divisions, and Members saved!");
        };
    }

}
