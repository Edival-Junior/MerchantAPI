package com.speedy.io.test.merchantAPI.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    public static HttpEntity<Object> getHttpEntity(String jtwToken, Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", jtwToken);

        Map map = new HashMap();
        params.forEach( (k, v) ->{
            map.put(k, v);
        });

        HttpEntity<Object> httpEntity = new HttpEntity<>(map, headers);
        return httpEntity;
    }
}
