package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "matchings")
public class Matching {

  @Id
  @GeneratedValue
  @Column(name = "match_id")
  private UUID id; // 식별자

  private Timestamp matchingTime;

  private String status;

  private LocalDateTime indate;

  @OneToOne
  @JoinColumn(name = "apply_id")
  private Apply apply;

}
