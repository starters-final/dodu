package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "mentors")
public class Mentor {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = true)
  private String password; // 비밀번호

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
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

  @OneToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToOne
  @JoinColumn(name = "wallet_id")
  private Wallet wallet;
}
