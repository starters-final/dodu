package com.starters.dodu.controller;

import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.starters.dodu.utils.StringToUuid.stringtoUUID;

@RequiredArgsConstructor
@RestController
public class ApiController {

  private final MentorService mentorService;

  @GetMapping("/mypage/{id}")
  public MentorDTO getMentorById(@PathVariable String id) {
    UUID uuid = stringtoUUID(id);
    return mentorService.findById(id);
  }

  @GetMapping("/mypage/{id}/applyList")
  public List<ApplyResultDTO> getApplyListById(@PathVariable String id) {
    UUID uuid = stringtoUUID(id);
    return mentorService.findAllDesc(id);
  }

  @GetMapping("/applyReq/{id}")
  public ApplyFormDTO.Response getApplyForm(@PathVariable String id) {
    UUID uuid = stringtoUUID(id);
    return mentorService.getApplyForm(id);
  }
}
