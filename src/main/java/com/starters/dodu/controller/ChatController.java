package com.starters.dodu.controller;

import com.starters.dodu.config.auth.LoginUser;
import com.starters.dodu.config.auth.SessionUser;
import com.starters.dodu.domain.Chat;
import com.starters.dodu.service.ChatService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
@Log4j2
public class ChatController {

//    @Autowired
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/{id}")
    public String chat(@PathVariable Long id, Model model, HttpServletResponse res) throws RuntimeException, IOException {
        try {
            Optional<Chat> chat = chatService.findById(id);
            model.addAttribute("chat", chat);
            log.info("@ChatController, chat GET()");
        } catch (Exception err) {
            String message = URLEncoder.encode(err.getMessage(), StandardCharsets.UTF_8);
            String redirectUrl = "/?alert=true&message=" + message;
            res.sendRedirect(redirectUrl);
        }
            return "chat";
    }

    @GetMapping("/chatList")
    public String chatlist(Model model, @LoginUser SessionUser user) {
        model.addAttribute("chatlist", chatService.getAllChatListByMentee(user.getId()));
        return "chat-list";
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
