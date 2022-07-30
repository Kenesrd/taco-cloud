package com.example.service;

import com.example.dao.UserRepository;
import com.example.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceUserRepository implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username);

            if (user != null){
                return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found!");
    }
}
