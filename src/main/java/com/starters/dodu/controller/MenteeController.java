package com.starters.dodu.controller;

import com.starters.dodu.dto.ApplyResultDTO;
import com.starters.dodu.dto.MenteeDTO;
import com.starters.dodu.service.ApplyService;
import com.starters.dodu.service.MenteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MenteeController {

    private final MenteeService menteeService;
    private final ApplyService applyService;

    // mentee 개인 페이지
    @GetMapping("/mypage/mentee/{id}")
    public MenteeDTO getMenteeById(@PathVariable String id) {
        Long menteeId = Long.parseLong(id);
        return menteeService.findById(menteeId);
    }

    @GetMapping("/api/v1/menteeApplyList/{id}")
    public List<ApplyResultDTO> getMenteeApplyList(@PathVariable String id) {
        return applyService.findAllByMenteeId(Long.parseLong(id));
    }

}
