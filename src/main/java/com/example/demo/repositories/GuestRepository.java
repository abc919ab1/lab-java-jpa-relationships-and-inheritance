package com.example.demo.repositories;

import com.example.demo.models.Event;
import com.example.demo.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {}
