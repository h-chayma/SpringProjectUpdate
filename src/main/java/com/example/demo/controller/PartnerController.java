package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.domain.Partner;
import com.example.demo.repository.PartnerRepository;

@Controller
@RequestMapping("/PARTENER")
public class PartnerController {

	@Autowired
	private PartnerRepository partnerRepository;

	@GetMapping("/partners")
	public String showPartnerList(Model model) {
		List<Partner> listPartners = partnerRepository.findAll();
		model.addAttribute("listPartners", listPartners);
		return "partners";
	}

	@GetMapping("/partners/new")
	public String CreateNewPartnerForm(Model model) {
		model.addAttribute("partner", new Partner());
		return "partner_form";
	}

	@PostMapping("/partners/save")
	public String savePartner(Partner partner) {
		partnerRepository.save(partner);
		return "redirect:/partners";
	}

	@GetMapping("/partners/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Partner partner = partnerRepository.findById(id).get();
		model.addAttribute("partner", partner);
		return "partner_form";
	}

	@GetMapping("/partners/delete/{id}")
	public String deletePartner(@PathVariable("id") Long id, Model model) {
		partnerRepository.deleteById(id);
		return "redirect:/partners";
	}
}
