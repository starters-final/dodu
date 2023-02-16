package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admins")
@Getter
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_id")
  private Long id; // 식별자

  private String nickname; // 닉네임

  private String password; // 비밀번호

  private LocalDateTime indate; // 생성일

}