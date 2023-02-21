package com.starters.dodu.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatDTO {

    private Long id;

    private String mentee_id;

    private String mentor_id;

    private String status;

    private LocalDateTime start_time;

    private LocalDateTime finish_time;
}
