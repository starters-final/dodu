package com.starters.dodu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Wallet;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "mentees")
public class Mentee {

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

  private String address;

  private LocalDateTime indate; // 생성일

}
