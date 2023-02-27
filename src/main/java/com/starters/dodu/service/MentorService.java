package com.starters.dodu.service;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.*;
import com.starters.dodu.repository.ApplyListRepository;
import com.starters.dodu.repository.MentorRepository;
import com.starters.dodu.repository.SaveApplyRepository;
import com.starters.dodu.repository.VerificationRepository;
import jakarta.persistence.NonUniqueResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MentorService {

    private final JavaMailSender javaMailSender;
    private final ApplyListRepository applyListRepository;
    private final MentorRepository mentorRepository;
    private final SaveApplyRepository saveApplyRepository;
    private final ApplyService applyService;
    private final VerificationRepository verificationRepository;

    public void sendMail(MailDTO mailDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDTO.getAddress());
        simpleMailMessage.setSubject(mailDTO.getTitle());
        simpleMailMessage.setText(mailDTO.getMessage());

        javaMailSender.send(simpleMailMessage);
    }

    @Transactional(readOnly = true)
    public List<MentorDTO> findAllByCategoryId(String id) {
        return mentorRepository.findAllByCategoryId(Long.parseLong(id)).stream()
                .map(MentorDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MentorDTO findById(String id) {
        Mentor entity = mentorRepository.findById(Long.parseLong(id))
              .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new MentorDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ApplyResultDTO> findAllDesc(String id) {
        return applyListRepository.findAllByIdOrderByIndateDesc(Long.parseLong(id)).stream()
                .map(ApplyResultDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ApplyFormDTO.GetApplyForm getApplyForm(String id) {
        Mentor entity = mentorRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ApplyFormDTO.GetApplyForm(entity);
    }

    // 맨토 관리
    public List<Mentor> findAllPass() {
        return mentorRepository.findAllByStatus(3);
    }
}

