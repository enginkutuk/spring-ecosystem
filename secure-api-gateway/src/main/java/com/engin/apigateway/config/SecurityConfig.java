package com.engin.apigateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // User configuration
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User
                .withUsername("user1")
                .password(passwordEncoder().encode("password"))
                // roles
                .roles("NORMAL")
                .build();
        UserDetails adminUser = User
                .withUsername("Admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(normalUser);
        inMemoryUserDetailsManager.createUser(adminUser);

        return inMemoryUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()//todo burası değişti hata attığı için
                // Role based Authentication
                .requestMatchers(new AndRequestMatcher(new AntPathRequestMatcher("/home/admin")))
                .hasRole("ADMIN")
                .requestMatchers(new AndRequestMatcher(new AntPathRequestMatcher("/home/normal")))
                .hasRole("NORMAL")
                .requestMatchers(new AndRequestMatcher(new AntPathRequestMatcher("/home/public")))
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();


        return httpSecurity.build();
    }
}