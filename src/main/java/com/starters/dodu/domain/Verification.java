package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "verifications")
public class Verification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verfication_id")
    private Long id; // 식별자

    private String file;

    private String status;

    private LocalDateTime indate;

    @OneToOne
    @JoinColumn(name = "mentor_id", unique = true)
    private Mentor mentor;


}
