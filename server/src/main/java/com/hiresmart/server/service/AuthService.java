package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.LoginRequest;
import com.hiresmart.server.dto.request.RegisterRequest;
import com.hiresmart.server.dto.response.LoginResponse;
import com.hiresmart.server.entity.User;
import com.hiresmart.server.enums.AccountStatus;
import com.hiresmart.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())   // Plain text for now
                .phone(request.getPhone())
                .accountStatus(AccountStatus.ACTIVE)
                .emailVerified(false)
                .build();

        userRepository.save(user);

        return "Registration Successful";
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {

            return LoginResponse.builder()
                    .message("User not found")
                    .build();

        }

        if (!user.getPassword().equals(request.getPassword())) {

            return LoginResponse.builder()
                    .message("Invalid Password")
                    .build();

        }

        return LoginResponse.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .message("Login Successful")
                .build();

    }

}