package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.TransactionClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionClientAPI transactionClientAPI;

    @PostMapping
    public ResponseEntity<String> findTransaction(@RequestHeader("Authorization") String authToken, @RequestBody String transactionId){
        Map<String, Object> map = new HashMap<>();
        map.put("transactionId", transactionId);
        return transactionClientAPI.getTransaction(authToken,map);
    }

    @PostMapping(value = "/list")
    public ResponseEntity<String> listTransaction(@RequestHeader("Authorization") String authToken, @RequestBody String transactionId){
        Map<String, Object> map = new HashMap<>();
        map.put("transactionId", transactionId);
        return transactionClientAPI.list(authToken,map);
    }
}
