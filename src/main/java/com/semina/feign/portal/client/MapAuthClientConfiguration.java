package com.semina.feign.portal.client;

import com.semina.feign.portal.auth.StaticAuthKeyMap;
import com.semina.feign.util.HttpUtil;
import feign.RequestInterceptor;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class MapAuthClientConfiguration implements HttpUtil {


    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.header("Authorization", StaticAuthKeyMap.AUTH_VALUE);
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 10000, 10);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {

            if (response.status() == 403) {
                StaticAuthKeyMap.AUTH_VALUE = "Daou2020!";
                return new RetryableException(response.status(), "retry", response.request().httpMethod(), null, response.request());
            }
            return new IllegalStateException();
        };
    }


}
