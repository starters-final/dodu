package com.starters.dodu.repository;

import com.starters.dodu.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ApplyListRepository extends JpaRepository<Apply, Long> {
  List<Apply> findAllByIdOrderByIndateDesc(Long id);
}
