package com.semina.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semina.feign.portal.client.model.MapData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RestAuthApiTest {


    @Test
    public void putMessage() {

        RestTemplate restTemplate = new RestTemplate();
        MapData mapData = new MapData();
        mapData.setKey("email");
        mapData.setValue("hsim@daou.co.kr");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer Daou2020!");
        httpHeaders.set("Content-Type", "application/json");

        try {
            HttpEntity entity = new HttpEntity(new ObjectMapper().writeValueAsString(mapData), httpHeaders);
            ResponseEntity<String> result = restTemplate.exchange("http://xman.daouoffice.com:8000/api/auth/push", HttpMethod.POST, entity, String.class);
            log.info(result.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json Parse Exception ", e);
        }

    }


    @Test
    public void getMessage() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer Daou2020!");
        httpHeaders.set("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity(httpHeaders);

        Map<String, String> params = new HashMap<>();
        params.put("key", "email");

        ResponseEntity<String> result = restTemplate.exchange("http://xman.daouoffice.com:8000/api/auth/get/{key}", HttpMethod.GET, entity, String.class, params);
        log.info(result.getBody());
    }


}
