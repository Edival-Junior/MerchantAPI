package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.LoginClientAPI;
import com.speedy.io.test.merchantAPI.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class LoginController {

    @Autowired
    private LoginClientAPI clientAPI;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        return clientAPI.login(user.getEmail(), user.getPassword());
    }

}
