package com.luv2code.springboot.cruddemo.serurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        // Admin access to all endpoints
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/members").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/roles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/roles").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/roles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/roles/**").hasRole("ADMIN")

                        // Manager access to certain endpoints
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/roles/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/roles").hasRole("MANAGER")

                        // Employee access to view endpoints only
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/roles/**").hasRole("EMPLOYEE")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}


