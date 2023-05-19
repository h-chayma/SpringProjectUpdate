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
}
