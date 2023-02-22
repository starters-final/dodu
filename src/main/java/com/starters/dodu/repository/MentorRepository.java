package com.starters.dodu.repository;

import com.starters.dodu.domain.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MentorRepository extends CrudRepository<Mentor, Long> {
  List<Mentor> findAllByCategoryId(Long id);
  List<Mentor> findAllByStatusGreaterThanEqual(String status);
}
