package com.starters.dodu.controller;

import com.starters.dodu.dto.MentorApplyDTO;
import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ApiController {

  private final MentorService mentorService;

  @GetMapping("/mypage/{id}")
  public MentorDTO findById(@PathVariable String id) {
    UUID uuid = null;
    try {
      // UUID 형식의 문자열인 경우
      uuid = UUID.fromString(id);
    } catch (IllegalArgumentException e) {
      // UUID 형식이 아닌 경우, 숫자인 경우
      try {
        long longValue = Long.parseLong(id);
        uuid = UUID.nameUUIDFromBytes(String.valueOf(longValue).getBytes());
      } catch (NumberFormatException ex) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.", ex);
      }
    }
    return mentorService.findById(uuid);
  }

  @GetMapping("/mypage/{id}/applyList")
  public List<MentorApplyDTO> findAll() {
    return mentorService.findAllDesc();
  }

}
