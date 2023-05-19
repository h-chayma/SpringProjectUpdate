package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Answer;
import com.example.demo.repository.AnswerRepository;

@Controller
@RequestMapping("/answers")
public class AnswerController {

	@Autowired
	private AnswerRepository answerRepository;

	@GetMapping("/answers")
	public String showAnswerList(Model model) {
		List<Answer> listAnswers = answerRepository.findAll();
		model.addAttribute("listAnswers", listAnswers);
		return "answers";
	}

	@GetMapping("/answers/new")
	public String CreateNewAnswerForm(Model model) {
		model.addAttribute("answer", new Answer());
		return "answer_form";
	}

	@PostMapping("/answers/save")
	public String saveAnswer(Answer answer) {
		answerRepository.save(answer);
		return "redirect:/answers";
	}

	@GetMapping("/answers/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Answer answer = answerRepository.findById(id).get();
		model.addAttribute("answer", answer);
		return "answer_form";
	}

	@GetMapping("/answers/delete/{id}")
	public String deleteAnswer(@PathVariable("id") Long id, Model model) {
		answerRepository.deleteById(id);
		return "redirect:/answers";
	}
}
