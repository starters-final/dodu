package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "chat_logs")
public class ChatLog {
    @Id
    @GeneratedValue
    @Column(name = "chatlog_id")
    private UUID id;

    private String sendId;

    private String content;

    private LocalDateTime indate;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;


}
