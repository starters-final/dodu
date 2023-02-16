package com.starters.dodu.controller;

import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.service.MentorService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class MailController {

    private final MentorService mentorService;

    @GetMapping("/send")
    public MailDTO sendEmail(){
        MailDTO dto = new MailDTO();
        dto.setAddress("1871469@hansung.ac.kr");
        dto.setTitle("dodu");
        dto.setMessage("안녕하세요");

        mentorService.sendMail(dto);
        return dto;
    }
}
