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
import com.example.demo.domain.Test;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.TestRepository;

@Controller
@RequestMapping("/TEST")
public class TestController {

    @Autowired
    private TestRepository testRepository;

	@GetMapping("/tests")
	public String showTestsList(Model model) {
		List<Test> listTests = testRepository.findAll();
		model.addAttribute("listTests", listTests);
		return "tests";
	}

	@GetMapping("/tests/new")
	public String CreateNewTestForm(Model model) {
		model.addAttribute("test", new Test());
		return "test_form";
	}

	@PostMapping("/tests/save")
	public String saveTest(Test test) {
		testRepository.save(test);
		return "redirect:/tests";
	}

	@GetMapping("/tests/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Test test = testRepository.findById(id).get();
		model.addAttribute("test", test);
		return "test_form";
	}

	@GetMapping("/tests/delete/{id}")
	public String deleteTest(@PathVariable("id") Long id, Model model) {
		testRepository.deleteById(id);
		return "redirect:/tests";
	}
}
