package com.starters.dodu.controller;

import com.starters.dodu.config.auth.LoginUser;
import com.starters.dodu.config.auth.SessionUser;
import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentee;
import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.repository.CategoryRepository;
import com.starters.dodu.repository.MenteeRepository;
import com.starters.dodu.repository.MentorRepository;
import com.starters.dodu.dto.*;
import com.starters.dodu.service.ApplyService;
import com.starters.dodu.service.CategoryService;
import com.starters.dodu.service.MenteeService;
import com.starters.dodu.service.MentorService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CategoryService categoryService;
    private final MenteeService menteeService;
    private final MentorService mentorService;
    private final ApplyService applyService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0", required = false) Long categoryId, HttpSession session) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/doduLogin")
    public String login(){
        return "login";
    }

    @GetMapping("/applyForm/{id}")
    public String getApplyForm(@PathVariable String id, Model model, @LoginUser SessionUser user, HttpSession session) {
        ApplyFormDTO.GetApplyForm applyFormDTO = mentorService.getApplyForm(id);
        model.addAttribute("mentorData", applyFormDTO);
        return "apply-form";
    }

    @GetMapping("/applyResult")
    public String getApplyResult(@RequestParam String menteeId, @RequestParam String mentorId, Model model) {
        ApplyResultDTO apply = applyService.findByMenteeIdAndMentorId(Long.parseLong(menteeId), Long.parseLong(mentorId));
        MenteeDTO mentee = menteeService.findById(Long.parseLong(menteeId));
        model.addAttribute("mentee", mentee);
        model.addAttribute("apply", apply);
        return "apply-result";
    }

    @GetMapping("/mentee/applyList/{id}")
    public String getMenteeApplyList(@PathVariable String id, Model model) {
        MenteeDTO mentee = menteeService.findById(Long.parseLong(id));
        List<ApplyResultDTO> applyList = applyService.findAllByMenteeId(Long.parseLong(id));
        model.addAttribute("mentee", mentee);
        model.addAttribute("applyList", applyList);
        return "mentee-apply-list";
    }

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

}
