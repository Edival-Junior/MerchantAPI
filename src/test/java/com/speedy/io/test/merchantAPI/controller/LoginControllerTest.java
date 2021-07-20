package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.LoginClientAPI;
import com.speedy.io.test.merchantAPI.entity.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.properties")
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginClientAPI loginClientAPI;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void login() {
        loginClientAPI.url = "testurl.com";

        User user = new User();

        user.setEmail("demo@financialhouse.io");
        user.setPassword("cjaiU8CV");

        ResponseEntity<String> entity = new ResponseEntity<>("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYyNjc0MDIxM30.JbzH9A10hiNTyMX9l6QR4PhJYVgQKgLOeoRWOoK9-_U", HttpStatus.OK);

        Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class))).thenReturn(entity);
        Mockito.when(loginClientAPI.login(anyString(),anyString())).thenReturn(entity);

        String jwtReturned = loginController.login(user).getBody();
        Assert.assertNotNull(jwtReturned);
    }
}