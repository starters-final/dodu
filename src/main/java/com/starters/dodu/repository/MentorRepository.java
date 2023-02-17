package com.starters.dodu.repository;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MentorRepository extends CrudRepository<Mentor, Long> {

  Optional<Mentor> findById(String id);
  List<Mentor> findAllByCategory(Category category);

}
