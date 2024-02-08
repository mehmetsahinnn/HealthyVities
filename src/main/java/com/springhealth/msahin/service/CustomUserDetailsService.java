package com.springhealth.msahin.service;

import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userEntity = userRepository.findByUsername(username);

        String role = userEntity.getIsAdmin() == 1 ? "ADMIN" : "USER";

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(role)
                .build();
    }
}

