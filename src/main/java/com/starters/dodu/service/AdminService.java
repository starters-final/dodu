package com.starters.dodu.service;

import com.starters.dodu.domain.Admin;
import com.starters.dodu.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminService{
    private final AdminRepository adminRepository;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public boolean authenticate(String adminName, String password) {

        Optional<Admin> admin = adminRepository.findAdminByAdminNameAndPassword(adminName, password);
        System.out.println(admin);
        if (admin != null && admin.get().getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    public Optional<Admin> findAdminByAdminNameAndPassword(String adminName, String password){
        return adminRepository.findAdminByAdminNameAndPassword(adminName, password);
    }
}
