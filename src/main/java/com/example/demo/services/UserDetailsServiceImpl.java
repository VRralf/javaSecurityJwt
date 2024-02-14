package com.example.demo.services;

import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var client = clientRepository.findByEmail(username);
        if(client == null){
            throw new UsernameNotFoundException("User not found");
        }
        return User
                .withUsername(client.getEmail())
                .password(client.getPassword())
                .roles("CLIENT")
                .build();
    }
}
