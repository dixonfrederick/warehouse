package com.example.warehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                                .requestMatchers("/users").permitAll() // Allow all requests to /users
                                .requestMatchers("/products").permitAll() // Allow all requests to /products
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults()) // Use default settings for http basic auth
                .csrf(csrf -> csrf.disable()); // Disable CSRF for non-browser clients like Postman

        return http.build();
    }
}
