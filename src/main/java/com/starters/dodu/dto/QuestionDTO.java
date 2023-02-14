package com.starters.dodu.dto;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Question;

import java.util.UUID;

public class QuestionDTO {

    private UUID id;

    private String question;

    private Category category;

    public QuestionDTO(Question entity) {
      this.id = entity.getId();
      this.question = entity.getQuestion();
      this.category = entity.getCategory();
    }
}
