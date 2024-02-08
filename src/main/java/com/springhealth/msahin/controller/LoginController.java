package com.springhealth.msahin.controller;

import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users loginDetails) {

        Users user = userService.findByUsername(loginDetails.getUsername());

        if (user != null && passwordEncoder.matches(loginDetails.getPassword(), user.getPassword())) {

            String token = userService.tokenBuilder(user);
            Map<String, Object> response = userService.getUserDetailsWithToken(user, token);

            return ResponseEntity.ok().body(response);
        }
        else {
            return ResponseEntity.badRequest().body("{\"error\":\"Kullanıcı adı veya şifre hatalı!\"}");
        }
    }
}