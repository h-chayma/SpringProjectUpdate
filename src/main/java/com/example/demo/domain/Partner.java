package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="partners")
public class Partner extends User{
	
	private String company;

	public Partner(Long id, String fullName, String email, String password, String role) {
		super(id, fullName, email, password, role);
		// TODO Auto-generated constructor stub
	}

	public Partner() {

	}
	
	public Partner(Long id, String fullName, String email, String password, String role, String company) {
		super(id, fullName, email, password, role);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
