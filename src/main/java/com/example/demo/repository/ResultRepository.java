package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    // Add custom query methods if needed
}
