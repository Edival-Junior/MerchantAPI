package com.speedy.io.test.merchantAPI.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginClientAPI {

    @Value("${merchant.api.login.url}")
    public String url;

    private RestTemplate restTemplate;

    public LoginClientAPI(){
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> login(String email, String password){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        Map map = new HashMap();
        map.put("email", email);
        map.put("password", password);

        HttpEntity<Object> httpEntity = new HttpEntity<>(map, headers);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }

}
