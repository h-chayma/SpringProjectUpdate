package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Proposition;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Long> {
    // Add custom query methods if needed
}


