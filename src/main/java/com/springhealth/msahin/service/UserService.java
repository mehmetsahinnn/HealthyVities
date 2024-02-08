package com.springhealth.msahin.service;

import com.springhealth.msahin.model.Users;
import com.springhealth.msahin.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // -> 1 gün
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
}