package com.springboot.learning.SpringBoot.controller;

import com.springboot.learning.SpringBoot.models.User;
import com.springboot.learning.SpringBoot.Repository.UserRepository;
import com.springboot.learning.SpringBoot.Service.UserService;
import com.springboot.learning.SpringBoot.Utils.JWTutil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTutil jwTutil;

    // ✅ REGISTER API
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        if (userRepository.findByEmail(email).isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }

        User newUser = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password)) // ✅ Encode password before saving
                .build();

        userService.createUser(newUser);

        return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }

    // ✅ LOGIN API
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "User not registered"), HttpStatus.NOT_FOUND);
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>(Map.of("error", "Invalid Password"), HttpStatus.UNAUTHORIZED);
        }

        String token = jwTutil.generateToken(email); // ✅ Generate JWT
        return ResponseEntity.ok(Map.of("token", token));
    }
}



