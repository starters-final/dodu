package com.starters.dodu.repository;

import com.starters.dodu.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByAdminNameAndPassword(String adminName, String password);
}
