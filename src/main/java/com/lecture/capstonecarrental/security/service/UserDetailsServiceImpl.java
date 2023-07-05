package com.lecture.capstonecarrental.security.service;

import com.lecture.capstonecarrental.domain.User;
import com.lecture.capstonecarrental.repositories.UserRepository;
import com.lecture.capstonecarrental.security.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found with email"));

        return UserDetailsImpl.build(user);
    }
}
