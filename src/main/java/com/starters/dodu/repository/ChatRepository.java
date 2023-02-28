package com.starters.dodu.repository;

import com.starters.dodu.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
  List<Chat> findAllByMentee_Id(Long id);
}
