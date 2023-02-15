package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private UUID id;

    private String question;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
