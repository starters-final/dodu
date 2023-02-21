package com.starters.dodu.repository;

import com.starters.dodu.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findById(Long id);
}
