package com.springhealth.msahin.controller;

import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.repository.UserRepository;
import com.springhealth.msahin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody Users newUser) {

        if (userService.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body(userService.UserAlreadyExists());
        }
        else {
            Users savedUser = userService.save(newUser);
            return ResponseEntity.ok(savedUser);
        }
    }
}
