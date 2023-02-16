package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "walletlogs")
public class WalletLog {
    @Id
    @GeneratedValue
    @Column(name = "walletlog_id")
    private UUID id;

    private String plus;

    private String minus;

    private LocalDateTime indate;

    @ManyToOne
    @JoinColumn(name = "mentee_id")
    private Mentee mentee;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    private String admin;
}
