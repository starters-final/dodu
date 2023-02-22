package com.starters.dodu.controller;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Mentee;
import com.starters.dodu.service.ApplyService;
import com.starters.dodu.domain.Mentor;
import com.starters.dodu.domain.Verification;
import com.starters.dodu.service.MenteeService;
import com.starters.dodu.service.MentorService;
import com.starters.dodu.service.VerificationService;
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

    @GetMapping("/admin")
    public String getHome(){
        return "adminhome";
    }

    // varification 관리
    @GetMapping("/admin/veri")
    public String getVeris(Model model) {
        List<Verification> verification = verificationService.findAll();
        model.addAttribute("verification", verification);
        return "adminverification";
    }

    // mentee 관리
    @GetMapping("/admin/mentee")
    public String getMentees(Model model) {
        List<Mentee> mentees = menteeService.findAll();
        model.addAttribute("mentees", mentees);
        return "adminmentee";
    }

    // mentor 관리
    @GetMapping("/admin/mentor")
    public String getMentors(Model model) {
        List<Mentor> mentors = mentorService.findAllPass();
        model.addAttribute("mentors", mentors);
        return "adminmentor";
    }


    @GetMapping("/admin/apply")
    public String getApplyList(Model model){
        List<Apply> applylist = applyService.findAll();
        model.addAttribute("applylist", applylist);
        return "adminapply";
    }

}
