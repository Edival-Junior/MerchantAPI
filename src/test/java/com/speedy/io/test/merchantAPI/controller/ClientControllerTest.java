package com.speedy.io.test.merchantAPI.controller;

import com.speedy.io.test.merchantAPI.client.ClientAPI;
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
public class ClientControllerTest {

    @InjectMocks
    private ClientController controller;

    @Mock
    private ClientAPI clientAPI;

    @Before
    public void setUp(){
        clientAPI.url = "someurl.com";
    }

    @Test
    public void getClient() {
        when(clientAPI.getClient(anyString(), any(HashMap.class))).thenReturn(new ResponseEntity("{}", HttpStatus.OK));
        ResponseEntity<String> responseEntity = controller.getClient("someJWTValid", "123456");
        Assert.assertNotNull(responseEntity.getBody());
    }
}