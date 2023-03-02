package com.starters.dodu.repository;

import com.starters.dodu.domain.Mentor;
import com.starters.dodu.domain.Verification;
import org.springframework.data.domain.Sort;
import com.starters.dodu.domain.enums.VerificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {

    List<Verification> findAllByStatusNot(int status);
//    List<Verification> findAll(Sort sort);
    Optional<Verification> findByMentorId(Long mentor_id);



}
