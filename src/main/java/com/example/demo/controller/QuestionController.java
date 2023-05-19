package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Question;
import com.example.demo.domain.Test;
import com.example.demo.repository.QuestionRepository;

@Controller
@RequestMapping("/QUESTION")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

	@GetMapping("/questions")
	public String showQuestionList(Model model) {
		List<Question> listQuestions = questionRepository.findAll();
		model.addAttribute("listQuestions", listQuestions);
		return "questions";
	}

	@GetMapping("/questions/new")
	public String CreateNewQuestionForm(Model model) {
		model.addAttribute("question", new Question());
		return "question_form";
	}

	@PostMapping("/questions/save")
	public String saveQuestion(Question question) {
		questionRepository.save(question);
		return "redirect:/questions";
	}

	@GetMapping("/questions/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Question question = questionRepository.findById(id).get();
		model.addAttribute("question", question);
		return "question_form";
	}

	@GetMapping("/questions/delete/{id}")
	public String deleteQuestion(@PathVariable("id") Long id, Model model) {
		questionRepository.deleteById(id);
		return "redirect:/questions";
	}
}
