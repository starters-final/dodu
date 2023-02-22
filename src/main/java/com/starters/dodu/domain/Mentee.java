package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

  @Builder
  public Mentee(Long id, String password, String email, String nickname, String phone, int age, String gender, String address) {
    this.id = id;
    this.password = password;
    this.email = email;
    this.nickname = nickname;
    this.phone = phone;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  public Mentee update(String nickname) {
    this.nickname = nickname;

    return this;
  }



}
