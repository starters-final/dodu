package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue
    @Column(name = "chat_id")
    private UUID id;

    private String mentee_id;

    private String mentor_id;

    private String status;

    private Timestamp start_time;

    private Timestamp finish_time;

}
