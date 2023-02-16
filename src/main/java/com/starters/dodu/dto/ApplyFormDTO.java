package com.starters.dodu.dto;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.domain.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ApplyFormDTO {

  @Getter
  @NoArgsConstructor
  public static class GetApplyForm {
    private Long id;
    private String nickname;
    private String image;
    private String university;
    private String major;
    private List<QuestionsDto> questions = new ArrayList<>();

    public GetApplyForm(Mentor mentor) {
      this.id = mentor.getId();
      this.nickname = mentor.getNickname();
      this.university = mentor.getUniversity();
      this.image = mentor.getImage();
      this.major = mentor.getMajor();
      this.questions = mentor.getCategory().getQuestions().stream()
              .map(QuestionsDto::new)
              .collect(Collectors.toList());
    }
  }

  @Getter
  public static class QuestionsDto {
    private Long id;
    private String question;

    public QuestionsDto(Question question) {
      this.id = question.getId();
      this.question = question.getQuestion();
    }
  }

}
