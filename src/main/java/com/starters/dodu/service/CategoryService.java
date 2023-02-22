package com.starters.dodu.service;

import com.starters.dodu.dto.CategoryDTO;
import com.starters.dodu.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public List<CategoryDTO> findAll() {
    return categoryRepository.findAll().stream()
            .map(CategoryDTO::new)
            .collect(Collectors.toList());
  }

}