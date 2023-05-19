package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.AnswerRepository;


@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    // Endpoints for Answer operations

    // ...
}

