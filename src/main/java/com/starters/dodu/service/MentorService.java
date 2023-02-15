package com.starters.dodu.service;

import com.starters.dodu.dto.MailDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class MentorService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(MailDTO mailDTO){


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDTO.getAddress());
        simpleMailMessage.setSubject(mailDTO.getTitle());
        simpleMailMessage.setText(mailDTO.getMessage());

        javaMailSender.send(simpleMailMessage);




    }
}
