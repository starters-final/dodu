package com.starters.dodu.controller;

import com.starters.dodu.domain.Mentee;
import com.starters.dodu.service.MenteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final MenteeService menteeService;

    // mentee 관리
    @GetMapping("/admin/mentee")
    public String getMentees(Model model) {
        List<Mentee> mentees = menteeService.findAll();
        model.addAttribute("mentees", mentees);
        return "adminmentee";
    }

}
