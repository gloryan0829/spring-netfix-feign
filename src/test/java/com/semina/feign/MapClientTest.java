package com.semina.feign;

import com.semina.feign.portal.client.MapClient;
import com.semina.feign.portal.client.model.MapData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
public class MapClientTest {

    @Autowired
    private MapClient mapClient;

    @Test
    public void pushTest() {
        MapData mapData = MapData.builder().key("A")
                .value("Semina").build();

        String result = mapClient.push(mapData);

        log.info("result : " + result);

        Assert.isTrue(result.equals(mapData.getValue()), "저장된 리턴 값은 Value와 동일하다");
    }

    @Test
    public void getTest() {
        String result = mapClient.get("A");

        log.info("result : " + result);
    }
}
