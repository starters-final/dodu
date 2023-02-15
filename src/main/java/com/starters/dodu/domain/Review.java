package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private UUID id;

    private String content;

    private Timestamp indate;

    @OneToOne
    @JoinColumn(name = "matching_id")
    private Matching matching;
}
