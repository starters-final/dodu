package com.starters.dodu.dto;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentor;
import com.starters.dodu.domain.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ApplyDTO {
//  private MentorDTO mentorDto;
//  private QuestionDTO questionDto;

  private UUID id;

  private String nickname;

  private String image;

  private String university;

  private String major;

  private Category category;

  private List<QuestionDTO> question;

  public ApplyDTO(Mentor mentor, Question question) {
    this.id = mentor.getId();
    this.nickname = mentor.getNickname();
    this.image = mentor.getImage();
    this.university = mentor.getUniversity();
    this.major = mentor.getMajor();
    this.category = mentor.getCategory();
  }

}
