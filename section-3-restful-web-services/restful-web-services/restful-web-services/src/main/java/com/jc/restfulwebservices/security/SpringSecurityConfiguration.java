package com.jc.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    // We are overriding the default security filter chain that is defined by Spring Security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Checks that all requests are authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // If a request is not authenticated, show a login pop up (not default web page)
        http.httpBasic(withDefaults());

        // Check for CSRF (which would impact POST and PUT requests) and disable it
        http.csrf().disable();

        return http.build();
    }
}
