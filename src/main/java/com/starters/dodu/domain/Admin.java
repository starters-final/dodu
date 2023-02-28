package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admins")
@Getter
@NoArgsConstructor
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_id")
  private Long id; // 식별자

  private String nickname; // 운영자 닉네임
  private String adminName; // 운영자 로그인을 위한 아이디

  private String password; // 비밀번호

  private LocalDateTime indate; // 생성일

}