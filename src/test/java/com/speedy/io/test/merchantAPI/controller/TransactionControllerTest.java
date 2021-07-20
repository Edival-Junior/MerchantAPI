package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.TransactionClientAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.properties")
public class TransactionControllerTest {

    @InjectMocks
    private  TransactionController transactionController;

    @Mock
    private TransactionClientAPI transactionClientAPI;

    private String jwt;

    @Before
    public void setUp() {
        transactionClientAPI.getTransactionUrl = "testurl.com";
        transactionClientAPI.listUrl = "testurl.com";
        jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYyNjc0MDIxM30.JbzH9A10hiNTyMX9l6QR4PhJYVgQKgLOeoRWOoK9-_U";

    }
    @Test
    public void listTransaction() {
        when(transactionClientAPI.list(anyString(), any(HashMap.class))).thenReturn(new ResponseEntity("{}", HttpStatus.OK));
        ResponseEntity<String> responseEntity = transactionController.listTransaction("someJWTValid", "123456");
        Assert.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void findTransaction() {
        when(transactionClientAPI.getTransaction(anyString(), any(HashMap.class))).thenReturn(new ResponseEntity("{}", HttpStatus.OK));
        ResponseEntity<String> responseEntity = transactionController.findTransaction("someJWTValid", "123456");
        Assert.assertNotNull(responseEntity.getBody());
    }
}