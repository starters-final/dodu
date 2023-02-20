package com.starters.dodu.controller;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentee;
import com.starters.dodu.domain.Mentor;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.repository.CategoryRepository;
import com.starters.dodu.repository.MenteeRepository;
import com.starters.dodu.repository.MentorRepository;
import com.starters.dodu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CategoryRepository categoryRepository;
    private final MenteeRepository menteeRepository;
    private final MentorRepository mentorRepository;
    private final MentorService mentorService;
    @GetMapping("/")
    public String index(Model model) {
        Optional<Mentee> mentee = menteeRepository.findById(1l);
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        List<Mentor> mentors = mentorRepository.findAllByCategory(categories.get(0));
        model.addAttribute("mentee", mentee);
        model.addAttribute("categories", categories);
        model.addAttribute("mentors", mentors);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/applyRequest/{id}")
    public String getApplyForm(@PathVariable String id, Model model) {
        ApplyFormDTO.GetApplyForm applyFormDTO = mentorService.getApplyForm(id);
        model.addAttribute("mentorData", applyFormDTO);
        return "offertomentor";
    }

    @GetMapping("/offertomentor")
    public String offertomentor(){
        return "offertomentor";
    }

    @GetMapping("/layout")
    public String phoneLay(){return "/layout/phonelay";  }

    @GetMapping("/menteechecked")
    public String menteechecked(){ return "menteechecked";
    }

    @GetMapping("/mymentoring")
    public String mymentoring(){ return "mymentoring";
    }

    @RequestMapping("/chat")
    public String chat() {return "chat";}

}
