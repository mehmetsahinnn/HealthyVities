package com.springhealth.msahin.controller;

import com.springhealth.msahin.config.EmailException;
import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.repository.UserRepository;
import com.springhealth.msahin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UsersController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> userData(@PathVariable Integer userId) {
        Optional<Users> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            List<Users> usersList = userRepository.findAll();
            return ResponseEntity.ok(usersList);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        Users user = userRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/forgot-email")
    public ResponseEntity<?> forgotEmail(@RequestParam String email) {
        Users user = userService.findByEmail(email);
        if (user != null) {
            String token = userService.tokenBuilder(user);
            try {
                userService.sendPasswordResetEmail(user, token);
                return ResponseEntity.ok().build();
            } catch (EmailException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
