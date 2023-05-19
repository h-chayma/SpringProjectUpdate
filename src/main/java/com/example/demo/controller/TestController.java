package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.TestRepository;

@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    // Endpoints for Test operations

    // ...
}
