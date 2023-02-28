package com.starters.dodu.service;

import com.starters.dodu.domain.Chat;
import com.starters.dodu.domain.ChatLog;
import com.starters.dodu.dto.ChatDTO;
import com.starters.dodu.dto.ChatLogDTO;
import com.starters.dodu.repository.ChatLogRepository;
import com.starters.dodu.repository.ChatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatLogRepository chatLogRepository;
    private final ChatRepository chatRepository;

    //chatlog db 저장
    @Transactional
    public void postChatLog(ChatLogDTO chatLogDTO){
        // Chat을 레포에서 가져온다 (ChatLogDTO 내의 chat_id를 이용하여)
        Long chat_id = chatLogDTO.getChat_id();
        Optional<Chat> chat_ = chatRepository.findById(chat_id);
        Chat chat = chat_.get();

        ChatLog chatLog = new ChatLog();
        chatLog.setSendId(chatLogDTO.getSend_id());
        chatLog.setContent(chatLogDTO.getContent());
        chatLog.setIndate(chatLogDTO.getIndate());
        chatLog.setChat(chat);

        chatLogRepository.save(chatLog);
    }

    public Optional<Chat> findById(Long id) throws RuntimeException {
        Optional<Chat> chat = chatRepository.findById(id);
        LocalDate now = LocalDate.now();
        LocalDateTime start = LocalDateTime.parse(chat.get().getStartTime());
        LocalDateTime finish = LocalDateTime.parse(chat.get().getStartTime());

        System.out.println(LocalDateTime.now() + " this is local");
        System.out.println(LocalDateTime.parse(chat.get().getStartTime()));
        System.out.println(LocalDateTime.parse(chat.get().getFinishTime()));

        if (now.isAfter(ChronoLocalDate.from(start)) && now.isBefore(ChronoLocalDate.from(finish))) {
            return chat;
        }
        else throw new RuntimeException("아직 입장할 수 없어요!");
    }

    //전체 채팅방 조회
    public List<Chat> getAllChatList(){
        return chatRepository.findAll();
    }

    public List<Chat> getAllChatListByMentee(Long id) {
        return chatRepository.findAllByMentee_Id(id);
    }

    @Transactional
    public ChatDTO createChat(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setMentee(chatDTO.getMentee());
        chat.setMentor(chatDTO.getMentor());
        chat.setStartTime(chatDTO.getStartTime());
        chat.setFinishTime(chatDTO.getStartTime().substring(0, 11)
                + (Integer.parseInt(chatDTO.getStartTime().substring(11, 13)) + 1)
                + chatDTO.getStartTime().substring(14, 16)
        );
        chat.setStatus(0);

        Chat savedChat = chatRepository.save(chat);
        return new ChatDTO(savedChat);

    }
}
