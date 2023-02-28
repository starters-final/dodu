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


    //멘토 블랙 관리
    @Transactional
    public void updateMentorStatus(Long id, MentorDTO status){
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 멘토는 존재하지 않습니다."));

        mentor.update(Integer.parseInt(status.getStatus()));
    }
    // 멘토 정렬
//    public List<Mentor> findAllPass(String sortBy){
//        List<Mentor> resultList;
//        /*Sort sort;*/
//        switch (sortBy) {
//            case "id": // 번호순
//                resultList = mentorRepository.findByStatusOrderByIdAsc(3);
//                //sort = Sort.by(Sort.Direction.ASC, "id");
//                break;
//            case "name": // 이름순
//                //sort = Sort.by(Sort.Direction.ASC, "nickname");
//                break;
//            case "university": // 대학순
//                //sort = Sort.by(Sort.Direction.ASC, "university");
//                break;
//            case "major": // 전공순
//                //sort = Sort.by(Sort.Direction.ASC, "major");
//                break;
//            case "gender": // 성별순
//                //sort = Sort.by(Sort.Direction.ASC, "gender");
//                break;
//            case "signUpDate": // 가입일순
//                //sort = Sort.by(Sort.Direction.ASC, "indate");
//                break;
//            default:
//                resultList = new List<Mentor>();
//                //sort = Sort.by(Sort.Direction.ASC, "id");
//        }
//        return resultList;

//    }
}

