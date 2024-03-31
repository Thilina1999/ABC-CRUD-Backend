package com.example.abc.controller;

import com.example.abc.entity.Staff;
import com.example.abc.messages.Message;
import com.example.abc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<Message> login(@RequestBody Staff staff){
        return authService.checKUser(staff);
    }
}
