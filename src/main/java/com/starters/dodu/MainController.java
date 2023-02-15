package com.starters.dodu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String first(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("offer")
    public String offer(){
        return "offertomentor";
    }

    @GetMapping("/layout")
    public String phoneLay(){return "/layout/phonelay";  }

}
