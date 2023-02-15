package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admins")
@Getter
public class Admin {

  @Id @GeneratedValue
  @Column(name = "id")
  private UUID id; // 식별자

  private String nickname; // 닉네임

  private String password; // 비밀번호

  private String grade;

  private String department;

  private LocalDateTime indate; // 생성일

}
