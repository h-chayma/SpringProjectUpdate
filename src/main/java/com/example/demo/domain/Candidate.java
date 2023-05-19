package com.example.demo.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "candidates")
public class Candidate extends User {
	public Candidate(Long id, String fullName, String email, String password, String role) {
		super(id, fullName, email, password, role);
		// TODO Auto-generated constructor stub
        setRole("user");
	}

	private int phone;

	public Candidate() {
		super();
        setRole("user");
	}

	public Candidate(Long id, String fullName, String email, String password, String role, int phone) {
		super(id, fullName, email, password, role);
		this.phone = phone;
        setRole("user");
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}