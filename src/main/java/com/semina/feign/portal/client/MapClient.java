package com.semina.feign.portal.client;

import com.semina.feign.portal.client.model.MapData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mapClient", url = "http://xman.daouoffice.com:8000/api/public")
public interface MapClient extends FeignClientBase {

    @PostMapping("/push")
    String push(@RequestBody MapData mapData);

    @GetMapping("/get/{key}")
    String get(@PathVariable("key") String key);

}
