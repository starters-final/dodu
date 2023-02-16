package com.starters.dodu.service;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.repository.ApplyListRepository;
import com.starters.dodu.repository.MentorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MentorService {

    private final JavaMailSender javaMailSender;
    private final ApplyListRepository applyListRepository;
    private final MentorRepository mentorRepository;

    public void sendMail(MailDTO mailDTO) {
      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setTo(mailDTO.getAddress());
      simpleMailMessage.setSubject(mailDTO.getTitle());
      simpleMailMessage.setText(mailDTO.getMessage());

      javaMailSender.send(simpleMailMessage);

    }

    @Transactional(readOnly = true)
    public MentorDTO findById(String id) {
      Mentor entity = mentorRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

      return new MentorDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ApplyResultDTO> findAllDesc(String id) {
      return applyListRepository.findAllDesc(id).stream()
              .map(ApplyResultDTO::new)
              .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ApplyFormDTO.GetApplyForm getApplyForm(String id) {
      Mentor entity = mentorRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

      return new ApplyFormDTO.GetApplyForm(entity);
    }
}
