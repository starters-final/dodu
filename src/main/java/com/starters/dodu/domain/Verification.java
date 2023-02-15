package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "verifications")
public class Verification {
    @Id
    @GeneratedValue
    @Column(name = "verification_id")
    private UUID id; // 식별자

    private String file;

    private String status;

    private LocalDateTime indate;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentorId;


}
