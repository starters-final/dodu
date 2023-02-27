package com.starters.dodu.controller;

import com.starters.dodu.config.auth.CustomOAuth2UserService;
import com.starters.dodu.config.auth.LoginUser;
import com.starters.dodu.config.auth.SessionUser;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.*;
import com.starters.dodu.service.ApplyService;
import com.starters.dodu.service.CategoryService;
import com.starters.dodu.service.MenteeService;
import com.starters.dodu.service.MentorService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CategoryService categoryService;
    private final MenteeService menteeService;
    private final MentorService mentorService;
    private final ApplyService applyService;
    // 추가
    private final CustomOAuth2UserService customOAuth2UserService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0", required = false) Long categoryId, HttpSession session) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        // check
        System.out.println("[getAttrName] : " + session.getAttributeNames());
        System.out.println("[servletContext] : " +session.getServletContext());
        System.out.println("[user] : " +session.getAttribute("user"));
        //System.out.println("[user] : " +session.getAttribute("user").toString());
        return "index";
    }

    @GetMapping("/doduLogin")
    public String login(){
        return "login";
    }

    // 추가
    @GetMapping("/doduLogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/applyForm/{id}")
    public String getApplyForm(@PathVariable String id, Model model, @LoginUser SessionUser user, HttpSession session) {
        ApplyFormDTO.GetApplyForm applyFormDTO = mentorService.getApplyForm(id);
        model.addAttribute("mentorData", applyFormDTO);
        return "apply-form";
    }

    @GetMapping("/mentor/apply/confirm/{id}")
    public String getMentorApplyConfirm(@PathVariable String id, Model model) {
        ApplyResultDTO apply = applyService.findById(Long.parseLong(id));
        model.addAttribute("apply", apply);
        return "mentor-apply-confirm";
    }

    @GetMapping("/mentee/applyResult")
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

}
