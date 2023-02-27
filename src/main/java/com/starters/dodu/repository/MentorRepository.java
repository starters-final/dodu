package com.starters.dodu.repository;

import com.starters.dodu.domain.Mentor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends CrudRepository<Mentor, Long> {
  List<Mentor> findAllByCategoryId(Long id);
  List<Mentor> findAllByStatusEquals(String status);

  Optional<Mentor> findById(Long id);

  @Query(value = "select m from Mentor m join Verification v on m.id=v.mentor.id and v.status=3")
  List<Mentor> findAllByStatus(int status);


}
