package com.starters.dodu.controller;

import com.starters.dodu.dto.ChatGptResponseDTO;
import com.starters.dodu.dto.ChatGptRequestDTO;
import com.starters.dodu.dto.QuestionRequestDTO;
import com.starters.dodu.service.ChatGptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatgpt")
public class ChatGptController {
    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptService chatGptService){
        this.chatGptService = chatGptService;
    }

    @PostMapping("/question")
    public ChatGptResponseDTO sendQuestion(@RequestBody QuestionRequestDTO requestDTO){
        return chatGptService.askQuestion(requestDTO);
    }

}