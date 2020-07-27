package com.semina.feign;

import com.semina.feign.portal.client.model.MapData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RestApiTest {


    @Test
    public void putMessage() {

        RestTemplate restTemplate = new RestTemplate();
        MapData mapData = new MapData();
        mapData.setKey("email");
        mapData.setValue("hsim@daou.co.kr");

        String result = restTemplate.postForObject("http://xman.daouoffice.com:8000/api/public/push", mapData, String.class);
        log.info(result);
    }

    @Test
    public void getMessage() {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("key", "email");
        String result = restTemplate.getForObject("http://xman.daouoffice.com:8000/api/public/get/{key}", String.class, params);
        log.info(result);
    }
}
