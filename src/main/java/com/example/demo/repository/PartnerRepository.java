package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    // Add custom query methods if needed
}


