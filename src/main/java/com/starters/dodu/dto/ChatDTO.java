package com.starters.dodu.dto;

import com.starters.dodu.domain.Chat;
import com.starters.dodu.domain.Mentee;
import com.starters.dodu.domain.Mentor;
import lombok.Data;

@Data
public class ChatDTO {

    private Long id;

    private Mentee mentee;

    private Mentor mentor;

    private int status;

    private String startTime;

    private String finishTime;

    public ChatDTO(Mentee mentee, Mentor mentor, String startTime) {
        this.mentee = mentee;
        this.mentor = mentor;
        this.startTime = startTime;
    }

    public ChatDTO(Chat chat) {
        this.id = chat.getId();
        this.mentee = chat.getMentee();
        this.mentor = chat.getMentor();
        this.startTime = chat.getStartTime();
        this.finishTime = chat.getFinishTime();
        this.status = chat.getStatus();
    }

}
