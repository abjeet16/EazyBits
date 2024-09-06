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

        // Define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // Define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                // Admin access to all endpoints
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/roles/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/members/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")

                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/members/**").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/roles/**").hasAnyRole("ADMIN","MANAGER")

                                .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.POST, "/api/roles").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.POST, "/api/members").hasAnyRole("ADMIN","MANAGER")

                                .requestMatchers(HttpMethod.DELETE, "/api/roles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}





