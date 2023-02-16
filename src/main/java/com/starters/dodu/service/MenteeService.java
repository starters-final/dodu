package com.starters.dodu.service;

import com.starters.dodu.domain.Mentee;
import com.starters.dodu.dto.MenteeDTO;
import com.starters.dodu.repository.MenteeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenteeService {

    private final MenteeRepository menteeRepository;

    public MenteeDTO findById(Long id) {
        Mentee entity = menteeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        return new MenteeDTO(entity);
    }
}
