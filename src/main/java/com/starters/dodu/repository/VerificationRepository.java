package com.starters.dodu.repository;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.domain.Verification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VerificationRepository extends JpaRepository<Verification, Long> {

    List<Verification> findAllByStatusNot(int status);
    List<Verification> findAll(Sort sort);
    Optional<Verification> findByMentorId(Long mentor_id);



}
