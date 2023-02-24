package com.starters.dodu.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    // 비밀번호 암호화하여 저장
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests((requests) -> {
                    try {
                        requests
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/profile")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).permitAll()
                                //.requestMatchers(new AntPathRequestMatcher("/mypage/**")).hasRole("ROLE_MENTEE")
                                .requestMatchers(new AntPathRequestMatcher("/applyForm/**")).hasRole("ROLE_MENTEE")
                                .requestMatchers(new AntPathRequestMatcher("/mentee/applyList/**")).hasRole("ROLE-MENTEE")
                                .anyRequest().permitAll() // 임시 - 수정 필요
                                //.anyRequest().authenticated()
                                //.anyRequest().hasRole("ROLE_MENTEE")
                            .and()
                                .logout()
                                .logoutRequestMatcher(new AntPathRequestMatcher("/doduLogout"))
                                .logoutSuccessUrl("/")
                            .and()
                                .oauth2Login().loginPage("/doduLogin").defaultSuccessUrl("/").userInfoEndpoint().userService(customOAuth2UserService);

                                //.oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return http.build();
    }
}
