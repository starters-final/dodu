package com.starters.dodu.service;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Matching;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.repository.ApplyListRepository;
import com.starters.dodu.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplyService {

  private final ApplyListRepository applyListRepository;
  private final MatchingRepository matchingRepository;

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

  public int checkMatchTime(ApplyFormDTO applyFormDTO) {
    List<String> matchTimeList = Arrays.asList(
            applyFormDTO.getMatchTime1().substring(0, 13),
            applyFormDTO.getMatchTime2().substring(0, 13),
            applyFormDTO.getMatchTime3().substring(0, 13)
    );
    List<Matching> match = matchingRepository.findAllByApply_Mentor(applyFormDTO.getMentor());
    if (match.size() == 0) return 0;

    for (int i = 0; i < matchTimeList.size(); i++) {
      for (int j = 0; j < match.size(); j++) {
        if (matchTimeList.get(i).equals(match.get(j).getSelectedMatchTime().substring(0, 13))) {
          return i + 1;
        }
      }
    }
    return 0;
  }

  @Transactional(rollbackFor = RuntimeException.class)
  public ApplyFormDTO saveApply(ApplyFormDTO applyFormDTO) {

    int status = checkMatchTime(applyFormDTO);

    if (status != 0) throw new RuntimeException(status + " 번째 제안 시간은 이미 멘토님의 dodu가 잡혀있는 시간이에요ㅠ");

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

    applyListRepository.save(apply);

    if (applyListRepository.findAllByMentee_IdAndMentor_Id(apply.getMentee().getId(), apply.getMentor().getId()).size() >= 2) {
      throw new RuntimeException("이미 신청한 멘토입니다.");
    }

    return ApplyFormDTO.applyDto(apply);
  }

  public List<Apply> findAll(){
    return applyListRepository.findAll();
  }

  public void updateApplyStatus(Long id, String status) {
    Apply apply = applyListRepository.findById(id).orElse(new Apply());
    if (apply.equals(new Apply())) throw new RuntimeException("Apply not found with id : " + id);
    if (apply.getStatus().equals("0")) apply.setStatus("1");
    applyListRepository.save(apply);
  }

}
