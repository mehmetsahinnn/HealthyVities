package com.springhealth.msahin.service;

import com.springhealth.msahin.config.EmailException;
import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JavaMailSender mailSender;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mailSender = mailSender;
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Users save(Users user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public String tokenBuilder(Users user) {
        int tokenExpiration = 86400000; // 1 gün
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, "SecretKey")
                .compact();
    }

    public Map<String, Object> getUserDetailsWithToken(Users user, String token) {
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("userId", user.getId());
        response.put("height", user.getHeight());
        response.put("weight", user.getWeight());
        response.put("isAdmin", user.getIsAdmin());
        return response;
    }

    public JSONObject UserAlreadyExists(){
        JSONObject json = new JSONObject();
        json.put("message", "User already exists!");
        return json;
    }

    public Users findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void sendPasswordResetEmail(Users user, String token) throws EmailException {
        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("healthyvities@gmail.com");
        passwordResetEmail.setTo(user.getEmail());
        passwordResetEmail.setSubject("Password Reset Request");
        passwordResetEmail.setText("To reset your password, click the link below:\n" + "https://www.healthyvities.com.tr/reset?token=" + token);

        try {
            mailSender.send(passwordResetEmail);
        } catch (Exception e) {
            throw new EmailException("Error sending password reset email");
        }
    }
}