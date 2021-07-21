package com.test.springboot.study.config.auth;

import com.test.springboot.study.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;
    @Override

    // KJMIN Says..
    // /api/v1 하위는 GUEST 사용자로 변경
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers()
                .frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                //.antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .antMatchers("/api/v1/**").hasRole(Role.GUEST.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}