package com.starters.dodu.service;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.repository.ApplyListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplyService {

  private final ApplyListRepository applyListRepository;

  public List<ApplyResultDTO> findAllByMenteeId(Long id) {
    return applyListRepository.findAllByMenteeId(id).stream()
            .map(ApplyResultDTO::new)
            .collect(Collectors.toList());
  }

  public ApplyResultDTO findByMenteeIdAndMentorId(Long menteeId, Long mentorId) {
    Apply entity = applyListRepository.findByMentee_IdAndMentor_Id(menteeId, mentorId)
            .orElseThrow(() -> new IllegalArgumentException("해당 멘토에게 지원하지 않았습니다. id = " + mentorId));

    return new ApplyResultDTO(entity);
  }

  public ApplyResultDTO findById(Long id) {
    Apply entity = applyListRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

    return new ApplyResultDTO(entity);
  }
  public List<Apply> findAll(){
    return applyListRepository.findAll();
  }

  public void updateApplyStatus(Long id, String status) {
    int updatedRows = applyListRepository.setStatusForApply(id, "1");
    if (updatedRows == 0) {
      throw new RuntimeException("Apply not found with id : " + id);
    }
  }

}
