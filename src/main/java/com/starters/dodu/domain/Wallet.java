package com.starters.dodu.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {

  @Id
  @GeneratedValue
  @Column(name = "wallet_id")
  private UUID id; // 식별자

  @Size(min = 3, max = 15)
  private String point;

  private LocalDateTime indate; // 생성일

}
