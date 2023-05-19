package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Add custom query methods if needed
}

