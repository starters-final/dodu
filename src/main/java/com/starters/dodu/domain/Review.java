package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String content;

    private Timestamp indate;

    @OneToOne
    @JoinColumn(name = "matching_id")
    private Matching matching;
}
