package com.starters.dodu.service;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.MentorApplyDTO;
import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.repository.ApplyListRepository;
import com.starters.dodu.repository.MentorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
  public MentorDTO findById(UUID id) {
      Mentor entity = mentorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

      return new MentorDTO(entity);
  }

  @Transactional(readOnly = true)
  public List<MentorApplyDTO> findAllDesc() {
      return applyListRepository.findAllDesc().stream()
            .map(MentorApplyDTO::new)
            .collect(Collectors.toList());
  }
}
