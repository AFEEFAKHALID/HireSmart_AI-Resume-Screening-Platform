package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.LoginRequest;
import com.hiresmart.server.dto.request.RegisterRequest;
import com.hiresmart.server.dto.response.LoginResponse;
import com.hiresmart.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
    ) {

        String response = authService.register(request);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(response);

    }

}