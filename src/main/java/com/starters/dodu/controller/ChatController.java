package com.starters.dodu.controller;

import com.starters.dodu.domain.Chat;
import com.starters.dodu.dto.ApplyFormDTO;
import com.starters.dodu.dto.ChatDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.ui.Model;
import com.starters.dodu.dto.ChatLogDTO;
import com.starters.dodu.service.ChatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Log4j2
public class ChatController {

    @Autowired
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/{id}")
    public String chat(@PathVariable Long id, Model model) {
        Optional<Chat> chat = chatService.findById(id);
        model.addAttribute("chat", chat);
        log.info("@ChatController, chat GET()");

        return "chat";
    }

    @GetMapping("/chatlist")
    public String chatlist(Model model) {
        model.addAttribute("chatlist", chatService.getAllChatList());
        return "chatlist";
    }

    @GetMapping("/chatgpt")
    public String chatgpt(){
        return "chatgpt";
    }

//    @ResponseStatus(HttpStatus.OK)
//    @PostMapping("/chat/{chat_id}")
//    public ResponseEntity<ChatLogDTO> postChatLog(@PathVariable("chat_id") Long chat_id, @RequestBody ChatLogDTO chatLogDTO){
//        ChatLogDTO createdDto = chatService.postChatLog(chat_id, chatLogDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
//    }
}
