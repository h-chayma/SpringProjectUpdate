package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "propositions")
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propositionText;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Proposition() {
    }

    public Proposition(String propositionText, Question question) {
        this.propositionText = propositionText;
        this.question = question;
    }


}