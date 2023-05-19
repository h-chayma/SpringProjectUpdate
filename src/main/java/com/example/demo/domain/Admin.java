package com.example.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

	public Admin(Long id, String fullName, String email, String password, String role) {
		super(id, fullName, email, password, role);
	}
}