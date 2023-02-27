package com.starters.dodu.dto;


import com.starters.dodu.domain.Verification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VerificationDTO {
    Long id;

    String file;

    int status;

    LocalDateTime indate;

    Long mentor_id;



    public VerificationDTO(Verification entity) {
        this.id = entity.getId();
        this.file = entity.getFile();
        this.status = entity.getStatus();
        this.indate = entity.getIndate();
        this.mentor_id = entity.getMentor().getId();

    }

}
