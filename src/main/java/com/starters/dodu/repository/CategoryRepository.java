package com.starters.dodu.repository;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  List<Category> findAll();
  List<Mentor> findAllById(Long id);
}
