package com.starters.dodu.controller;


import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/offertomentor")
    public String offer(){
        return "offertomentor";
    }

    @GetMapping("/layout")
    public String phoneLay(){return "/layout/phonelay";  }




}
