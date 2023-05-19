package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Partner;
import com.example.demo.repository.PartnerRepository;

@Controller
@RequestMapping("/PARTENER")
public class PartnerController {

    @Autowired
    private PartnerRepository partnerRepository;

	@GetMapping("/partners")
	public String showUserList(Model model) {
		List<Partner> listPartners = partnerRepository.findAll();
		model.addAttribute("listPartners", listPartners);
		return "partners";
	}
}

