package com.starters.dodu.controller;

import com.starters.dodu.dto.*;
import com.starters.dodu.service.ApplyService;
import com.starters.dodu.service.MatchingService;
import com.starters.dodu.service.MentorService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.starters.dodu.utils.StringToUuid.stringtoUUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class ApiController {

  private final MentorService mentorService;
  private final ApplyService applyService;
  private final MatchingService matchingService;
  @Value("${chatgpt.api.key.script}")
  private String chatgptApiKeyScript;

  @GetMapping
  public ResponseEntity<List<MentorDTO>> getMentorsByCategoryId(@RequestParam(defaultValue = "0", required = false) String categoryId) {
    List<MentorDTO> mentors = mentorService.findAllByCategoryId(categoryId);
    return ResponseEntity.ok(mentors);
  }

  @GetMapping("/mypage/{id}")
  public ResponseEntity<MentorDTO> getMentorById(@PathVariable String id) {
    UUID uuid = stringtoUUID(id);
    return ResponseEntity.ok(mentorService.findById(id));
  }

  @GetMapping("/send")
  public ResponseEntity<MailDTO> sendEmail(@RequestParam String address, @RequestParam String title, @RequestParam String message) {
    MailDTO dto = new MailDTO();
    dto.setAddress(address);
    dto.setTitle(title);
    dto.setMessage(message);

    mentorService.sendMail(dto);
    return ResponseEntity.ok(dto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/offer/saveApply")
  public void saveApply(ApplyFormDTO applyFormDTO, HttpServletResponse response) throws IOException {
    ApplyFormDTO apply = mentorService.saveApply(applyFormDTO);
    sendEmail(
            apply.getMentor().getEmail(),
            apply.getMentor().getNickname() + "님 새로운 dodu 신청서가 도착했어요!",
            "http://localhost:8080/mentor/apply/confirm/" + apply.getId()
    );
    response.sendRedirect("/applyResult?menteeId=" + apply.getMentee().getId() + "&mentorId=" + apply.getMentor().getId());
  }

//  @PutMapping("/setApplyStatus")
  public ResponseEntity<String> updateApplyStatus(Long applyId, String status) {
    try {
      if(status.equals("0")) {
        applyService.updateApplyStatus(applyId, status);
        return ResponseEntity.ok("Apply status updated successfully");
      } else return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/saveMatching")
  public void saveMatching(MatchingDTO matchingDTO, HttpServletResponse response) throws IOException {
    MatchingDTO match = matchingService.saveMatching(matchingDTO);
    sendEmail(
            match.getApply().getMentor().getEmail(),
            match.getApply().getMentor().getNickname() + "님, " + match.getApply().getMentee().getNickname()  + " 멘티와의 매칭이 완료됐어요!",
            "http://localhost:8080/chat"
    );
    sendEmail(
            match.getApply().getMentee().getEmail(),
            match.getApply().getMentee().getNickname() + "님, " + match.getApply().getMentor().getNickname() + " 멘토가 DoDu를 수락했어요!",
            "http://localhost:8080/chat"
    );
    updateApplyStatus(match.getApply().getId(), match.getApply().getStatus());
    response.sendRedirect("/");
  }

  @GetMapping("/mypage/{id}/applyList")
  public List<ApplyResultDTO> getApplyListById(@PathVariable String id) {
    UUID uuid = stringtoUUID(id);
    return mentorService.findAllDesc(id);
  }

  @GetMapping("/applyResult")
  public ApplyResultDTO getApplyResultRest(@RequestParam String menteeId, @RequestParam String mentorId) {
    return applyService.findByMenteeIdAndMentorId(Long.parseLong(menteeId), Long.parseLong(mentorId));
  }

  @GetMapping("/config")
  public String getConfig() {
    return chatgptApiKeyScript;
  }

}
