package com.speedy.io.test.merchantAPI.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.speedy.io.test.merchantAPI.utils.RequestUtils.getHttpEntity;

@Service
public class ClientAPI {

    @Value("${merchant.api.client.url}")
    public String url;

    private RestTemplate restTemplate;

    public ClientAPI(){
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> getClient(String jtwToken, Map<String, Object> params) {
        HttpEntity<Object> httpEntity = getHttpEntity(jtwToken, params);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }

}
