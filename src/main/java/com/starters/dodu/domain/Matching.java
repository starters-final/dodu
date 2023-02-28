package com.starters.dodu.domain;

import com.starters.dodu.domain.enums.MatchingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "matchings")
public class Matching {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matching_id")
  private Long id; // 식별자

  private String selectedMatchTime;
  @Column(name = "status")
  private int status;
  public MatchingStatus getStatusEnum(){
    return MatchingStatus.fromStatusCode(status);
  }

  @CreationTimestamp
  private LocalDateTime indate;

  @OneToOne
  @JoinColumn(name = "apply_id")
  private Apply apply;

}
