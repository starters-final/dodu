package com.starters.dodu.domain;

import com.starters.dodu.dto.ChatDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    @ToString.Exclude
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "mentee_id")
    @ToString.Exclude
    private Mentee mentee;

    private String status;

    private String startTime;

    private String finishTime;

}
