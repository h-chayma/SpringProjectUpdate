package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Proposition;
import com.example.demo.repository.PropositionRepository;

@Controller
@RequestMapping("/PROPOSITION")
public class PropositionController {
	
    @Autowired
    private PropositionRepository propositionRepository;
	
	@GetMapping("/propositions")
	public String showPropositionList(Model model) {
		List<Proposition> listPropositions = propositionRepository.findAll();
		model.addAttribute("listPropositions", listPropositions);
		return "propositions";
	}

	@GetMapping("/propositions/new")
	public String CreateNewPropositionForm(Model model) {
		model.addAttribute("proposition", new Proposition());
		return "proposition_form";
	}

	@PostMapping("/propositions/save")
	public String saveProposition(Proposition proposition) {
		propositionRepository.save(proposition);
		return "redirect:/propositions";
	}

	@GetMapping("/propositions/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Proposition proposition = propositionRepository.findById(id).get();
		model.addAttribute("proposition", proposition);
		return "proposition_form";
	}

	@GetMapping("/propositions/delete/{id}")
	public String deleteProposition(@PathVariable("id") Long id, Model model) {
		propositionRepository.deleteById(id);
		return "redirect:/propositions";
	}
}
