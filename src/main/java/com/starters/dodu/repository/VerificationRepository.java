package com.starters.dodu.repository;

import com.starters.dodu.domain.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
    List<Verification> findAllByStatusNot(String status);
}
