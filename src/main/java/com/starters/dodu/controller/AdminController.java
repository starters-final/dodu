package com.starters.dodu.controller;

import com.starters.dodu.domain.*;
import com.starters.dodu.dto.CategoryDTO;
import com.starters.dodu.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final MenteeService menteeService;
    private final ApplyService applyService;
    private final MentorService mentorService;
    private final VerificationService verificationService;
    private final MatchingService matchingService;
    private final CategoryService categoryService;
    private final ChatService chatService;

    @GetMapping("/admin")
    public String getlogin(){
        return "admin-login";
    }

    @GetMapping("/admin/home")
    public String getHome(){
        return "admin-home";
    }

    // varification 관리
    @GetMapping("/admin/veri")
    public String getVeris(Model model) {
        List<Verification> verification = verificationService.findAll();
        model.addAttribute("verification", verification);
        return "admin-verification";
    }

    // mentee 관리
    @GetMapping("/admin/mentee")
    public String getMentees(Model model) {
        List<Mentee> mentees = menteeService.findAll();
        model.addAttribute("mentees", mentees);
        return "admin-mentee";
    }

    // mentor 관리
    @GetMapping("/admin/mentor")
    public String getMentors(Model model) {
        List<Mentor> mentors = mentorService.findAllPass();
        model.addAttribute("mentors", mentors);
        return "admin-mentor";
    }

    // 신청관리
    @GetMapping("/admin/apply")
    public String getApplyList(Model model){
        List<Apply> applylist = applyService.findAll();
        model.addAttribute("applylist", applylist);
        return "admin-apply";
    }

    // 매칭 관리
    @GetMapping("/admin/matching")
    public String getMatchings(Model model) {
        List<Matching> matching = matchingService.findAll();
        model.addAttribute("matching", matching);
        return "admin-matching";
    }

    // 채팅 관리
    @GetMapping("/admin/chat")
    public String getChats(Model model) {
        List<Chat> chat =  chatService.getAllChatList();
        model.addAttribute("chat", chat);
        return "admin-chat";
    }

    // 질문 관리
    @GetMapping("/admin/category")
    public String getCategoris(Model model) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "admin-category";
    }

}
