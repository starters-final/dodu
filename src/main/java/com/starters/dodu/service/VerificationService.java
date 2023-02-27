package com.starters.dodu.service;

import com.starters.dodu.domain.Verification;
import com.starters.dodu.domain.enums.VerificationStatus;
import com.starters.dodu.dto.VerificationDTO;
import com.starters.dodu.repository.VerificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;

    //검증관리
    public List<Verification> findAll(){
        return verificationRepository.findAllByStatusNot(3);
    }

    public List<Verification> findAll(String sortBy) {
        Sort sort;
        switch (sortBy) {
            case "id":
                sort = Sort.by(Sort.Direction.ASC, "mentor.id");
                System.out.println(sort);
                break;
            case "name":
                sort = Sort.by(Sort.Direction.ASC, "mentor.nickname");
                break;
            case "submitDate":
                sort = Sort.by(Sort.Direction.ASC, "indate");
                break;
            case "veriStatus":
                sort = Sort.by(Sort.Direction.ASC, "statusEnum.getStatus");
                System.out.println(sort);
                break;
            default:
                sort = Sort.by(Sort.Direction.ASC, "mentor.id");
        }
        return verificationRepository.findAll(sort);
    }

    @Transactional
    public void updateStatus(Long id, VerificationDTO status){
        Verification verification = verificationRepository.findByMentorId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토는 존재하지 않습니다."));


        verification.update(status.getStatus());

    }

}

