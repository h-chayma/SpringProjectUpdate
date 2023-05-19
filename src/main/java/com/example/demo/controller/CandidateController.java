package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Candidate;
import com.example.demo.repository.CandidateRepository;

@Controller
@RequestMapping("/CONDIDATE")
public class CandidateController {
	@Autowired
	private CandidateRepository candidateRepository;

	@GetMapping("/candidates")
	public String showCandidateList(Model model) {
		List<Candidate> listCandidates = candidateRepository.findAll();
		model.addAttribute("listCandidates", listCandidates);
		return "candidates";
	}

	@GetMapping("/candidates/new")
	public String CreateNewCandidateForm(Model model) {
		model.addAttribute("candidate", new Candidate());
		return "candidate_form";
	}

	@PostMapping("/candidates/save")
	public String saveCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
		return "redirect:/candidates";
	}

	@GetMapping("/candidates/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Candidate candidate = candidateRepository.findById(id).get();
		model.addAttribute("candidate", candidate);
		return "candidate_form";
	}

	@GetMapping("/candidates/delete/{id}")
	public String deleteCandidate(@PathVariable("id") Long id, Model model) {
		candidateRepository.deleteById(id);
		return "redirect:/candidates";
	}
}
