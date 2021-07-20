package com.speedy.io.test.merchantAPI.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.properties")
public class TransactionClientAPITest {

    @InjectMocks
    private TransactionClientAPI transactionClientAPI;

    @Mock
    private RestTemplate restTemplate;

    private String  jwt;

    @Before
    public void setUp() {
        transactionClientAPI.getTransactionUrl = "testurl.com";
        transactionClientAPI.listUrl = "testurl.com";
        jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYyNjc0MDIxM30.JbzH9A10hiNTyMX9l6QR4PhJYVgQKgLOeoRWOoK9-_U";

    }

    @Test
    public void getTransaction() {

        Map<String, Object> map = new HashMap<>();
        map.put("key","value");

        Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class))).thenReturn(new ResponseEntity<>("{}", HttpStatus.OK));

        ResponseEntity<String> responseEntity = transactionClientAPI.getTransaction(jwt, map);
        Assert.assertNotNull(responseEntity);
    }

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("key","value");

        Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class))).thenReturn(new ResponseEntity<>("{}", HttpStatus.OK));

        ResponseEntity<String> responseEntity = transactionClientAPI.list(jwt, map);
        Assert.assertNotNull(responseEntity);
    }
}