package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "mentees")
public class Mentee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "mentee_id")
  private Long id;

  @Column(nullable = true)
  private String password; // 비밀번호

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String nickname;

  private String phone;

  private int age;

  private String gender;

  private String address;

  private LocalDateTime indate; // 생성일

}
