package com.restaurante.Backend.Admin.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/menu").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/menu").permitAll() // Permitir acesso a todos
                        .requestMatchers(HttpMethod.PUT, "/menu").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/menu").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/user").hasRole("EMPREGADO") // Empregados só podem adicionar
                        .anyRequest().authenticated()
                )
                .build();
    }
}

