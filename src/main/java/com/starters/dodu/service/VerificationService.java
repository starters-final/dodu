package com.starters.dodu.service;

import com.starters.dodu.domain.Verification;
import com.starters.dodu.repository.VerificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;

    //검증관리
    public List<Verification> findAll(){
       return verificationRepository.findAllByStatusNot("통과");
    }

}

