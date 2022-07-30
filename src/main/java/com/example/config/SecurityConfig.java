package com.example.config;

import com.example.dao.UserRepository;
import com.example.entities.User;
import com.example.service.UserDetailsServiceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsServiceUserRepository userDetailsService (UserRepository userRepository) {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user != null) return user;
//            throw new UsernameNotFoundException("User '" + username + "' not found!");
//        };
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.
                authorizeRequests()
                    .antMatchers("/design", "/orders").hasRole("USER")
                    .antMatchers("/", "/**").permitAll()
                .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .and()
                        .oauth2Login()
                        .loginPage("/login")
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .build();
    }
}
