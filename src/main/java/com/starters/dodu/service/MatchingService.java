package com.starters.dodu.service;

import com.starters.dodu.domain.Matching;
import com.starters.dodu.dto.MatchingDTO;
import com.starters.dodu.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchingService {

  private final MatchingRepository matchingRepository;

  @Transactional
  public MatchingDTO saveMatching(MatchingDTO matchingDTO) {
    Matching match = new Matching();
    match.setId(matchingDTO.getId());
    match.setSelectedMatchTime(matchingDTO.getSelectedMatchTime());
    match.setStatus(matchingDTO.getStatus());
    match.setApply(matchingDTO.getApply());

    matchingRepository.save(match);

    return new MatchingDTO(match);
  }

  //admin 매칭 관리
  public List<Matching> findAll(){
    return matchingRepository.findAll();
  }
}
