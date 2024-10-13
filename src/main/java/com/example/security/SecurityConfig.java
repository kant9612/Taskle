package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .authorizeHttpRequests() // authorizeRequests() を authorizeHttpRequests() に変更
            .requestMatchers("/login", "/resources/**").permitAll() // antMatchers() を requestMatchers() に変更
            .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .permitAll()
            .and()
            .logout()
                .permitAll(); // ログアウトも許可
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
