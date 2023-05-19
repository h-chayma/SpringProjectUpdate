package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ResultRepository;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    // Endpoints for Result operations

    // ...
}
