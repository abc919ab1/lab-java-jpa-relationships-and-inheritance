package com.example.demo.repositories;

import com.example.demo.models.Event;
import com.example.demo.models.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {}
