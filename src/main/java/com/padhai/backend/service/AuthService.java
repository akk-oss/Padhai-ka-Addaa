package com.padhai.backend.service;

import com.padhai.backend.dto.LoginRequest;
import com.padhai.backend.dto.RegisterRequest;
import com.padhai.backend.entity.User;
import com.padhai.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.padhai.backend.security.JwtService;
import com.padhai.backend.dto.LoginResponse;
import com.padhai.backend.entity.Role;
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered";
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.STUDENT);

        userRepository.save(user);

        return "Registration Successful";
    }
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                user.getRole().name(),
                user.getFullName(),
                user.getEmail()
        );
    }
}