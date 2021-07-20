package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.ClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientAPI clientAPI;

    @PostMapping
    public ResponseEntity<String> getClient(@RequestHeader("Authorization") String authToken, @RequestBody String transactionId) {
        Map<String, Object> map = new HashMap<>();
        map.put("transactionId", transactionId);
        return clientAPI.getClient(authToken, map);
    }

}
