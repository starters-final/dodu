package com.starters.dodu.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "chat_logs")
public class ChatLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_log_id")
    private Long id;

    private String sendId;

    private String content;

    private LocalDateTime indate;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;


}
