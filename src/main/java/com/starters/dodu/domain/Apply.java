package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "applys")
@Getter
public class Apply {
  @Id
  @GeneratedValue
  @Column(name = "apply_id")
  private UUID id; // 식별자

  private Timestamp matchTime1;
  private Timestamp matchTime2;
  private Timestamp matchTime3;

  private String status;

  private LocalDateTime indate;

  @ManyToOne
  @JoinColumn(name = "mentee_id")
  private Mentee mentee;

  @ManyToOne
  @JoinColumn(name = "mentor_id")
  private Mentor mentorId;

}
