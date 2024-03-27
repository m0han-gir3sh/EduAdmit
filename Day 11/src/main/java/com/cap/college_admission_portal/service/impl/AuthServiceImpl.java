package com.cap.college_admission_portal.service.impl;

import static com.cap.college_admission_portal.model.enumerate.Role.ADMIN;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cap.college_admission_portal.dto.request.AuthenticationRequest;
import com.cap.college_admission_portal.dto.request.RegisterRequest;
import com.cap.college_admission_portal.dto.response.AuthenticationResponse;
import com.cap.college_admission_portal.model.*;
import com.cap.college_admission_portal.model.enumerate.Role;
import com.cap.college_admission_portal.repository.UserRepository;
import com.cap.college_admission_portal.util.JwtUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
 {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public boolean userRegistration(RegisterRequest request) {
        Optional<User> isUserExists = userRepository.findByEmail(request.getEmail());
        if (!isUserExists.isPresent()) {
            var user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.valueOf(request.getRole().toUpperCase()))
                    .build();
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AuthenticationResponse userAuthentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtUtil.generateToken(user);
        String admin = ADMIN.name();
        return AuthenticationResponse.builder()
                .token(token)
                .uid(user.getUid())
                .name(user.getName())
                .role(user.getRole())
                .email(user.getEmail())
                .admin(admin)
                .build();
    }
    
}
