package com.semina.feign.portal.client;

import com.semina.feign.portal.client.model.MapData;
import com.semina.feign.portal.config.DefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mapAuthClient", url = "${target.url:http://xman.daouoffice.com:8000}" +"/api/auth", configuration = {MapAuthClientConfiguration.class})
public interface MapAuthClient extends FeignClientBase{

    @PostMapping("/push")
    String push(@RequestBody MapData mapData);

    @GetMapping("/get/{key}")
    String get(@PathVariable("key") String key);
}
