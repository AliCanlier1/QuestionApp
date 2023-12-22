package com.springbootproject.QuestionApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails ali = User.builder()
                .username("ali")
                .password("{noop}ali")
                .roles("ADMIN", "MANAGER")
                .build();
        UserDetails furkan = User.builder()
                .username("furkan")
                .password("{noop}furkan")
                .roles("MANAGER")
                .build();
        UserDetails ozkan = User.builder()
                .username("ozkan")
                .password("{noop}ozkan")
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(ali, furkan, ozkan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/comments").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/comments/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/likes").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/likes/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/posts").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/posts/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }




}
