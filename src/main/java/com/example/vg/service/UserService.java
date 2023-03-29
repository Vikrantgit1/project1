package com.example.vg.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.vg.dto.UserRegistrationDto;
import com.example.vg.model.User;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
