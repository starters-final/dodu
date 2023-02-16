package com.starters.dodu.dto;

import com.starters.dodu.domain.Mentor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class MentorDTO {

  private Long id;
  private String email;
  private String nickname;

  private String phone;

  private int age;

  private String gender;

  private LocalDateTime indate; // 생성일

  private String image;

  private String university;

  private String major;

  private String status;

  private String matchCount;

  public MentorDTO(Mentor entity) {
    this.id = entity.getId();
    this.nickname = entity.getNickname();
    this.image = entity.getImage();
    this.university = entity.getUniversity();
    this.major = entity.getMajor();
    this.matchCount = entity.getMatchCount();
  }
}

