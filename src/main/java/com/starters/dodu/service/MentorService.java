package com.starters.dodu.service;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.repository.ApplyListRepository;
import com.starters.dodu.repository.MentorRepository;
import com.starters.dodu.repository.SaveApplyRepository;
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

    @Transactional(rollbackFor = NonUniqueResultException.class)
    public ApplyFormDTO saveApply(ApplyFormDTO applyFormDTO) {

        Apply apply = new Apply();
        apply.setId(applyFormDTO.getId());
        apply.setMatchTime1(applyFormDTO.getMatchTime1());
        apply.setMatchTime2(applyFormDTO.getMatchTime2());
        apply.setMatchTime3(applyFormDTO.getMatchTime3());
        apply.setStatus(applyFormDTO.getStatus());
        apply.setIndate(applyFormDTO.getIndate());
        apply.setMentee(applyFormDTO.getMentee());
        apply.setMentor(applyFormDTO.getMentor());
        apply.setQuestion(applyFormDTO.getQuestion());

        saveApplyRepository.save(apply);
        if(applyService.findByMenteeIdAndMentorId(apply.getMentee().getId(), apply.getMentor().getId()) == null) {
            throw new NonUniqueResultException("멘티와 멘토 사이에 이미 신청서가 존재합니다.");
        }

        return ApplyFormDTO.applyDto(apply);

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
    public List<Mentor> findAllPass(){

        return mentorRepository.findAllByStatusEquals("가입완료");
    }
}

