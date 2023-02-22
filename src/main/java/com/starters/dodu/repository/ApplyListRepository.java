package com.starters.dodu.repository;

import com.starters.dodu.domain.Apply;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApplyListRepository extends JpaRepository<Apply, Long> {
  List<Apply> findAllByIdOrderByIndateDesc(Long id);

  List<Apply> findAllByMenteeId(Long id);

  Optional<Apply> findByMentee_IdAndMentor_Id(Long menteeId, Long mentorId);

  @Transactional
  @Modifying
  @Query("UPDATE Apply a SET a.status = ?2 WHERE a.id = ?1")
  int setStatusForApply(Long id, String status);

}
