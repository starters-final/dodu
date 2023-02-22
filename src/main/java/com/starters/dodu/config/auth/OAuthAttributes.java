package com.starters.dodu.config.auth;

import com.starters.dodu.domain.Mentee;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    // 추가
    private String phone;
    private String gender;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String phone, String gender) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        // 추가
        this.phone = phone;
        this.gender = gender;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                // 추가
                .phone((String) attributes.get("phone"))
                .gender((String) attributes.get("gender"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                // 추가
                .phone((String) response.get("phone"))
                .gender((String) attributes.get("gender"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Mentee toEntity() {
        return Mentee.builder()
                .nickname(name)
                .email(email)
                // 추가
                .phone(phone)
                .gender(gender)
                .build();
    }
}