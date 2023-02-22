package com.starters.dodu.config.auth;

import com.starters.dodu.domain.Mentee;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long id; // 추가*
    private String name;
    private String email;
    // 추가
    private String phone;
    private String gender;

    public SessionUser(Mentee mentee) {
        this.id = mentee.getId();
        this.name = mentee.getNickname();
        this.email = mentee.getEmail();
        // 추가
        this.phone = mentee.getPhone();
        this.gender = mentee.getGender();
    }
}