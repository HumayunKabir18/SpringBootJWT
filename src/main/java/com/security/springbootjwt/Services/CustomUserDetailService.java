package com.security.springbootjwt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security.springbootjwt.Entites.user;
import com.security.springbootjwt.Repositories.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user usr = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException());
       return usr;
    }

}