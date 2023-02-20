package com.starters.dodu.repository;

import com.starters.dodu.domain.Category;
import com.starters.dodu.domain.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  List<Category> findAll();
}
