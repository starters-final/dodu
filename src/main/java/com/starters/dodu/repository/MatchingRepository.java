package com.starters.dodu.repository;

import com.starters.dodu.domain.Matching;
import com.starters.dodu.domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingRepository extends JpaRepository<Matching, Long> {

  List<Matching> findAllByApply_Mentor(Mentor mentor);
}
