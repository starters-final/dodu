package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;


@Entity
@Getter
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private UUID id;

    private String title;
}
