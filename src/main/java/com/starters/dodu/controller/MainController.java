package com.starters.dodu.controller;


import com.starters.dodu.dto.MailDTO;
import com.starters.dodu.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/offer")
    public String offer(){
        return "offertomentor";
    }

    @GetMapping("/menteechecked")
    public String menteechecked(){ return "menteechecked";
    }

    @GetMapping("/layout")
    public String phoneLay(){return "/layout/phonelay";  }




}
