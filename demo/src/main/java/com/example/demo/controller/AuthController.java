package com.example.demo.controller;
import com.example.demo.dto.LoginForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<String> login(@org.jetbrains.annotations.NotNull @Valid @RequestBody LoginForm loginForm) {
        // Simulate login logic
        return ResponseEntity.ok("Login successful for email: " + loginForm.getEmail());
    }
}
