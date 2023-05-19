package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public String viewHomePageCondidate(Model model) {

		return "redirect:/CONDIDATE/candidates";
	}

	@RequestMapping(value = "/partners", method = RequestMethod.GET)
	public String viewHomePagePartener(Model model) {

		return "redirect:/PARTENER/partners";
	}
}
