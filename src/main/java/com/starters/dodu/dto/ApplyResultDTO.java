package com.starters.dodu.dto;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Mentee;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ApplyResultDTO {
  private Long id;
  private String matchTime1;
  private String matchTime2;
  private String matchTime3;
  private String status;
  private LocalDateTime indate;
  private Mentee mentee;

  public ApplyResultDTO(Apply entity) {
    this.id = entity.getId();
    this.matchTime1 = entity.getMatchTime1();
    this.matchTime2 = entity.getMatchTime2();
    this.matchTime3 = entity.getMatchTime3();
    this.status = entity.getStatus();
    this.indate = entity.getIndate();
    this.mentee = entity.getMentee();
  }
}
