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
public class TransactionClientAPI {

    @Value("${merchant.api.transaction.list.url}")
    public String listUrl;

    @Value("${merchant.api.transaction.url}")
    public String getTransactionUrl;

    private RestTemplate restTemplate;

    public TransactionClientAPI(){
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> getTransaction(String jtwToken, Map<String, Object> params) {
        HttpEntity<Object> httpEntity = getHttpEntity(jtwToken, params);
        return restTemplate.exchange(getTransactionUrl, HttpMethod.POST, httpEntity, String.class);
    }

    public ResponseEntity<String> list(String jtwToken, Map<String, Object> params) {
        HttpEntity<Object> httpEntity = getHttpEntity(jtwToken, params);
        return restTemplate.exchange(listUrl, HttpMethod.POST, httpEntity, String.class);
    }

}